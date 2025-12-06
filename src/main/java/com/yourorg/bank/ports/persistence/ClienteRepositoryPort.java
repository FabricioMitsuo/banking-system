package com.yourorg.bank.ports.persistence;

import com.yourorg.bank.domain.model.Cliente;

public interface ClienteRepositoryPort {
  Cliente save(Cliente c);
  Cliente findByEmail(String email);
  Cliente findById(String id);
}
