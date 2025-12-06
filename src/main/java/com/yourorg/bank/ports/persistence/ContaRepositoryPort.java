package com.yourorg.bank.ports.persistence;

import com.yourorg.bank.domain.model.Conta;

public interface ContaRepositoryPort {
  Conta save(Conta c);
  Conta findById(String id);
}
