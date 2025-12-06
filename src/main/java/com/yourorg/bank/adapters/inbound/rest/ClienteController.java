package com.yourorg.bank.adapters.inbound.rest;

import com.yourorg.bank.application.service.ClienteService;
import com.yourorg.bank.domain.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ClienteDto dto) throws Exception {
    Cliente c = new Cliente();
    c.setNome(dto.nome); c.setEmail(dto.email); c.setCpf(dto.cpf); c.setTelefone(dto.telefone);
    c.setSenhaHash(dto.senha);
    Cliente salvo = clienteService.cadastrar(c, dto.faceBase64 == null ? new byte[0] : java.util.Base64.getDecoder().decode(dto.faceBase64));
    return ResponseEntity.ok(salvo);
  }
}

class ClienteDto { public String nome; public String email; public String cpf; public String telefone; public String senha; public String faceBase64; }
