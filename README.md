# Banking System - Esqueleto

## Pré-requisitos
- Java 17+
- Maven
- IntelliJ IDEA

## Como rodar localmente
1. Copie os arquivos deste esqueleto para um diretório `banking-system`.
2. Ajuste `application.properties` com credenciais (Twilio, Biometria) se for usar.
3. No terminal: `mvn spring-boot:run` ou rode `BankApplication` no IntelliJ.
4. Swagger UI disponível em `http://localhost:8080/swagger-ui/index.html`.

## Subir para GitHub
```bash
git init
git add .
git commit -m "Initial commit - banking system skeleton"
# criar repo no GitHub e depois:
git remote add origin git@github.com:SEU_USUARIO/banking-system.git
git branch -M main
git push -u origin main
```

## Observações importantes
- Este projeto é um **ponto de partida**. Para produção, implemente criptografia, HSM/KMS, testes de segurança, observabilidade e conformidade.
- Nunca envie imagens faciais sem consentimento e sem política de retenção conforme LGPD.
