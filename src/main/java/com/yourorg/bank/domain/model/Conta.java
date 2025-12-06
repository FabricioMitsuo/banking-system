package com.yourorg.bank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Conta {
  @Id
  private String id = UUID.randomUUID().toString();
  @OneToOne
  private Cliente cliente;
  private double saldo = 0.0;
  private double limite = 1000.0; // cheque especial
  private boolean bloqueada = false;

  public String getId() { return id; }
  public Cliente getCliente() { return cliente; }
  public void setCliente(Cliente cliente) { this.cliente = cliente; }
  public double getSaldo() { return saldo; }
  public void setSaldo(double saldo) { this.saldo = saldo; }
  public double getLimite() { return limite; }
  public void setLimite(double limite) { this.limite = limite; }
  public boolean isBloqueada() { return bloqueada; }
  public void setBloqueada(boolean bloqueada) { this.bloqueada = bloqueada; }
}
