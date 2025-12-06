package com.yourorg.bank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class CartaoVirtual {
  @Id
  private String id = UUID.randomUUID().toString();
  private String contaId;
  private String numeroToken;
  private String maskedNumber;
  private String cvv;
  private LocalDate vencimento;
  private boolean ativo = true;

  public String getId() { return id; }
  public String getContaId() { return contaId; }
  public void setContaId(String contaId) { this.contaId = contaId; }
  public String getNumeroToken() { return numeroToken; }
  public void setNumeroToken(String numeroToken) { this.numeroToken = numeroToken; }
  public String getMaskedNumber() { return maskedNumber; }
  public void setMaskedNumber(String maskedNumber) { this.maskedNumber = maskedNumber; }
  public String getCvv() { return cvv; }
  public void setCvv(String cvv) { this.cvv = cvv; }
  public LocalDate getVencimento() { return vencimento; }
  public void setVencimento(LocalDate vencimento) { this.vencimento = vencimento; }
  public boolean isAtivo() { return ativo; }
  public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
