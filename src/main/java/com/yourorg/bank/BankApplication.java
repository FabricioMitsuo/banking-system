package com.yourorg.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Bank API", version = "v1"))
@SpringBootApplication
public class BankApplication {
  public static void main(String[] args) {
    SpringApplication.run(BankApplication.class, args);
  }
}
