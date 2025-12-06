package com.yourorg.bank.ports.external;

import java.math.BigDecimal;

public interface BlockchainPort {
  String criarCarteira(String clienteId);
  boolean enviar(String carteiraOrigem, String enderecoDestino, BigDecimal valor, String token);
  BigDecimal consultarSaldo(String carteiraId, String token);
}
