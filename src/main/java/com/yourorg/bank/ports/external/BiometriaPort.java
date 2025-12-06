package com.yourorg.bank.ports.external;

public interface BiometriaPort {
  String registrarFace(String clienteId, byte[] imagemFace) throws Exception;
  boolean verificarFace(String faceTemplateId, byte[] imagemFace) throws Exception;
}
