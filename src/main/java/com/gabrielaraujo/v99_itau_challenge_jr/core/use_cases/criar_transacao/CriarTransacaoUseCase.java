package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs.CriarTransacaoUseCaseInput;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.outputs.CriarTransacaoUseCaseOutput;

public abstract class CriarTransacaoUseCase {
    public abstract CriarTransacaoUseCaseOutput executar(CriarTransacaoUseCaseInput input);
    protected abstract CriarTransacaoUseCaseOutput aplicarLogicaInterna(CriarTransacaoUseCaseInput input);
}
