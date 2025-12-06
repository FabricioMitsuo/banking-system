package com.yourorg.bank.ports.external;

public interface NotificacaoPort {
  void enviarSms(String telefone, String mensagem);
  void enviarEmail(String email, String assunto, String corpo);
}
