package com.yourorg.bank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Cliente {
  @Id
  private String id = UUID.randomUUID().toString();
  private String nome;
  private String email;
  private String cpf;
  private String telefone;
  private String senhaHash;
  private String faceTemplateId; // id do provider de biometria
  private LocalDateTime criadoEm = LocalDateTime.now();

  public String getId() { return id; }
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getCpf() { return cpf; }
  public void setCpf(String cpf) { this.cpf = cpf; }
  public String getTelefone() { return telefone; }
  public void setTelefone(String telefone) { this.telefone = telefone; }
  public String getSenhaHash() { return senhaHash; }
  public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
  public String getFaceTemplateId() { return faceTemplateId; }
  public void setFaceTemplateId(String faceTemplateId) { this.faceTemplateId = faceTemplateId; }
  public LocalDateTime getCriadoEm() { return criadoEm; }
}
