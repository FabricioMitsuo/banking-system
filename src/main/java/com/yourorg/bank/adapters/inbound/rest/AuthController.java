package com.yourorg.bank.adapters.inbound.rest;

import com.yourorg.bank.ports.external.BiometriaPort;
import com.yourorg.bank.ports.persistence.ClienteRepositoryPort;
import com.yourorg.bank.ports.external.NotificacaoPort;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final ClienteRepositoryPort clienteRepo;
  private final BiometriaPort biometria;
  private final NotificacaoPort notificacao;
  private final InMemory2FaService twoFaService = new InMemory2FaService();

  public AuthController(ClienteRepositoryPort clienteRepo, BiometriaPort biometria, NotificacaoPort notificacao) {
    this.clienteRepo = clienteRepo;
    this.biometria = biometria;
    this.notificacao = notificacao;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest req) throws Exception {
    var cliente = clienteRepo.findByEmail(req.email);
    if (cliente == null) return ResponseEntity.status(401).build();
    boolean faceOk = biometria.verificarFace(cliente.getFaceTemplateId(), req.faceBase64 == null ? new byte[0] : java.util.Base64.getDecoder().decode(req.faceBase64));
    if (!faceOk) return ResponseEntity.status(401).body("Falha na biometria");
    String code = twoFaService.generate(cliente.getId());
    notificacao.enviarSms(cliente.getTelefone(), "Seu código 2FA: " + code);

    java.util.Map<String, Object> body = new java.util.HashMap<>();
    body.put("userId", cliente.getId());
    body.put("2faPending", true);
    return ResponseEntity.ok(body);

  }

    }


class LoginRequest { public String email; public String senha; public String faceBase64; }
class TwoFaRequest { public String userId; public String code; }

class InMemory2FaService {
  private final java.util.Map<String,String> map = new java.util.concurrent.ConcurrentHashMap<>();
  public String generate(String userId) { String code = String.valueOf(new java.util.Random().nextInt(900000)+100000); map.put(userId, code); return code; }
  public boolean verify(String userId, String code) { return code != null && code.equals(map.get(userId)); }
}
//     public void setFaceTemplateId (String faceTemplateId){
//       this.faceTemplateId = faceTemplateId;
//     }
//     public LocalDateTime getCriadoEm () {
//       return criadoEm;
//     }
// }