package com.yourorg.bank.adapters.outbound.persistence;

import com.yourorg.bank.domain.model.Cliente;
import com.yourorg.bank.ports.persistence.ClienteRepositoryPort;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

interface SpringClienteJpa extends JpaRepository<Cliente, String> {
  Cliente findByEmail(String email);
}

@Component
public class SpringDataClienteRepository implements ClienteRepositoryPort {
  @Autowired
  private SpringClienteJpa repository;

  @Override
  public Cliente save(Cliente c) { return repository.save(c); }

  @Override
  public Cliente findByEmail(String email) { return repository.findByEmail(email); }

  @Override
  public Cliente findById(String id) { return repository.findById(id).orElse(null); }
}
