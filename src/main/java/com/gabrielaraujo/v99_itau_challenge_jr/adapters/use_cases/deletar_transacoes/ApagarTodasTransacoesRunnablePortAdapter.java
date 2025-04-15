package com.gabrielaraujo.v99_itau_challenge_jr.adapters.use_cases.deletar_transacoes;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories.TransacaoRepository;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.implementations.ports.ApagarTodasTransacoesRunnablePort;
import org.springframework.stereotype.Service;

@Service
public class ApagarTodasTransacoesRunnablePortAdapter implements ApagarTodasTransacoesRunnablePort {
    private final TransacaoRepository transacaoRepository;

    public ApagarTodasTransacoesRunnablePortAdapter(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public void executar() {
        transacaoRepository.deletarTodas();
    }
}
