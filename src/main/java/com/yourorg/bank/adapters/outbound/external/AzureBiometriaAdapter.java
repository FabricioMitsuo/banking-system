package com.yourorg.bank.adapters.outbound.external;

import com.yourorg.bank.ports.external.BiometriaPort;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AzureBiometriaAdapter implements BiometriaPort {
  private final OkHttpClient client = new OkHttpClient();
  private final String endpoint;
  private final String apiKey;

  public AzureBiometriaAdapter(@Value("${biometria.endpoint}") String endpoint,
                                @Value("${biometria.apikey}") String apiKey) {
    this.endpoint = endpoint;
    this.apiKey = apiKey;
  }

  @Override
  public String registrarFace(String clienteId, byte[] imagemFace) throws Exception {
    // TODO: implementar integração com provider real
    return "face-template-id-placeholder-" + clienteId;
  }

  @Override
  public boolean verificarFace(String faceTemplateId, byte[] imagemFace) throws Exception {
    // TODO: chamar API do provider para 1:1 face verification
    return true;
  }
}
