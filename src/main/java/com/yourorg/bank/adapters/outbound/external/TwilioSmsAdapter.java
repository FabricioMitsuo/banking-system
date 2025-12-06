package com.yourorg.bank.adapters.outbound.external;

import com.yourorg.bank.ports.external.NotificacaoPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioSmsAdapter implements NotificacaoPort {
  private final String accountSid;
  private final String authToken;

  public TwilioSmsAdapter(@Value("${twilio.sid:}") String accountSid,
                          @Value("${twilio.token:}") String authToken) {
    this.accountSid = accountSid;
    this.authToken = authToken;
  }

  @Override
  public void enviarSms(String telefone, String mensagem) {
    // TODO: integrar Twilio ou outro provider
    System.out.println("[SMS] para=" + telefone + " msg=" + mensagem);
  }

  @Override
  public void enviarEmail(String email, String assunto, String corpo) {
    // usar JavaMailSender (implementação omitida)
    System.out.println("[EMAIL] para=" + email + " assunto=" + assunto);
  }
}
