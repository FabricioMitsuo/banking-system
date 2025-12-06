package com.yourorg.bank.application.service;

import com.yourorg.bank.domain.model.Cliente;
import com.yourorg.bank.ports.persistence.ClienteRepositoryPort;
import com.yourorg.bank.ports.external.BiometriaPort;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ClienteService {
  private final ClienteRepositoryPort repo;
  private final BiometriaPort biometria;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public ClienteService(ClienteRepositoryPort repo, BiometriaPort biometria) {
    this.repo = repo;
    this.biometria = biometria;
  }

  public Cliente cadastrar(Cliente c, byte[] imagemFace) throws Exception {
    c.setSenhaHash(encoder.encode(c.getSenhaHash()));
    String faceId = biometria.registrarFace(c.getId(), imagemFace);
    c.setFaceTemplateId(faceId);
    return repo.save(c);
  }

  public Cliente findByEmail(String email) { return repo.findByEmail(email); }
}
