package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes;

public abstract class DeletarTransacoesUseCase {
    public abstract void executar();
    protected abstract void aplicarLogicaInterna();
}
