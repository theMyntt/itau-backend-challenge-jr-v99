package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.DeletarTransacoesUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.implementations.ports.ApagarTodasTransacoesRunnablePort;

public class DeletarTransacoesUseCaseImpl extends DeletarTransacoesUseCase {
    private final ApagarTodasTransacoesRunnablePort apagarTodasTransacoesRunnablePort;

    public DeletarTransacoesUseCaseImpl(ApagarTodasTransacoesRunnablePort apagarTodasTransacoesRunnablePort) {
        this.apagarTodasTransacoesRunnablePort = apagarTodasTransacoesRunnablePort;
    }

    @Override
    public void executar() {
        aplicarLogicaInterna();
    }

    @Override
    protected void aplicarLogicaInterna() {
        apagarTodasTransacoesRunnablePort.executar();
    }
}
