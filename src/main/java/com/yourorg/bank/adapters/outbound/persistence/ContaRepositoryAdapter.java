package com.yourorg.bank.adapters.outbound.persistence;

import com.yourorg.bank.domain.model.Conta;
import com.yourorg.bank.ports.persistence.ContaRepositoryPort;
import org.springframework.stereotype.Repository;

// Marca a classe como bean para o Spring gerenciar
@Repository
public class ContaRepositoryAdapter  implements ContaRepositoryPort{
    @Override
    public Conta save(Conta c) {
        return null;
    }

    @Override
    public Conta findById(String id) {
        return null;
    }

    // Implementar aqui todos os métodos definidos em ContaRepositoryPort.
        // Exemplo (substitua pelos métodos reais da sua interface):
        //
        // @Override
        // public Conta findById(String id) { ... }
        //
        // @Override
        // public Conta save(Conta conta) { ... }
        //
        // Use um repositório JPA, um cliente JDBC, ou uma estrutura em memória conforme necessário.
    }


