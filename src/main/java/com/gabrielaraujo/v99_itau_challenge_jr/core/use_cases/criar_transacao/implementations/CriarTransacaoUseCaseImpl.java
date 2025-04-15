package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories.TransacaoFactory;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.CriarTransacaoUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations.ports.SalvarTransacaoPort;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs.CriarTransacaoUseCaseInput;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.outputs.CriarTransacaoUseCaseOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class CriarTransacaoUseCaseImpl extends CriarTransacaoUseCase {
    private final SalvarTransacaoPort salvarTransacaoPort;

    public CriarTransacaoUseCaseImpl(SalvarTransacaoPort salvarTransacaoPort) {
        this.salvarTransacaoPort = salvarTransacaoPort;
    }

    @Override
    public CriarTransacaoUseCaseOutput executar(CriarTransacaoUseCaseInput input) {
        return aplicarLogicaInterna(input);
    }

    @Override
    protected CriarTransacaoUseCaseOutput aplicarLogicaInterna(CriarTransacaoUseCaseInput input) {
        var transacao = extrairTransacaoDo(input);
        var transacaoSalva = salvarTransacao(transacao);

        return CriarTransacaoUseCaseOutput.builder()
                .mensagem("Transação criada.")
                .idDaTransacao(transacaoSalva.getId().toString())
                .codigo(HttpStatus.CREATED)
                .build();
    }

    private TransacaoEntity extrairTransacaoDo(CriarTransacaoUseCaseInput input) {
        return TransacaoFactory.of(
                input.getValor(),
                input.getDataHora()
        );
    }

    private TransacaoEntity salvarTransacao(TransacaoEntity transacao) {
        var portInput = SalvarTransacaoPort.SalvarTransacaoPortInput.builder()
                .transacao(transacao)
                .build();
        var portOutput = salvarTransacaoPort.executar(portInput);
        return portOutput.getTransacao();
    }
}
