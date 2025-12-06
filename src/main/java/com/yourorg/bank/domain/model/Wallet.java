package com.yourorg.bank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Wallet {
  @Id
  private String id = UUID.randomUUID().toString();
  private String clienteId;
  private BigDecimal btc = BigDecimal.ZERO;
  private BigDecimal eth = BigDecimal.ZERO;
  private BigDecimal cdiProductBalance = BigDecimal.ZERO; // produto interno

  public String getId() { return id; }
  public String getClienteId() { return clienteId; }
  public void setClienteId(String clienteId) { this.clienteId = clienteId; }
  public BigDecimal getBtc() { return btc; }
  public void setBtc(BigDecimal btc) { this.btc = btc; }
  public BigDecimal getEth() { return eth; }
  public void setEth(BigDecimal eth) { this.eth = eth; }
  public BigDecimal getCdiProductBalance() { return cdiProductBalance; }
  public void setCdiProductBalance(BigDecimal cdiProductBalance) { this.cdiProductBalance = cdiProductBalance; }
}
