package com.yourorg.bank.application.service;

import com.yourorg.bank.domain.model.Conta;
import com.yourorg.bank.ports.persistence.ContaRepositoryPort;
import com.yourorg.bank.ports.external.NotificacaoPort;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
  private final ContaRepositoryPort contaRepo;
  private final NotificacaoPort notificacao;

  public ContaService(ContaRepositoryPort contaRepo, NotificacaoPort notificacao) {
    this.contaRepo = contaRepo;
    this.notificacao = notificacao;
  }

  public void sacar(String contaId, double valor) {
    Conta c = contaRepo.findById(contaId);
    if (c == null) throw new RuntimeException("Conta não encontrada");
    c.setSaldo(c.getSaldo() - valor);
    if (c.getSaldo() < 0) {
      notificacao.enviarSms(c.getCliente().getTelefone(), "Sua conta está negativa: " + c.getSaldo());
    }
    contaRepo.save(c);
  }
}
