package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories.TransacaoFactory;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.CriarTransacaoUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations.ports.SalvarTransacaoConsumerPort;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs.CriarTransacaoUseCaseInput;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.outputs.CriarTransacaoUseCaseOutput;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CriarTransacaoUseCaseImpl extends CriarTransacaoUseCase {
    private final SalvarTransacaoConsumerPort salvarTransacaoConsumerPort;

    public CriarTransacaoUseCaseImpl(SalvarTransacaoConsumerPort salvarTransacaoConsumerPort) {
        this.salvarTransacaoConsumerPort = salvarTransacaoConsumerPort;
    }

    @Override
    public CriarTransacaoUseCaseOutput executar(CriarTransacaoUseCaseInput input) {
        return aplicarLogicaInterna(input);
    }

    @Override
    protected CriarTransacaoUseCaseOutput aplicarLogicaInterna(CriarTransacaoUseCaseInput input) {
        var transacao = extrairTransacaoDo(input);

        salvarTransacao(transacao);

        return CriarTransacaoUseCaseOutput.builder()
                .codigoHttp(HttpStatus.CREATED.value())
                .build();
    }

    private TransacaoEntity extrairTransacaoDo(CriarTransacaoUseCaseInput input) {
        return TransacaoFactory.of(
                input.getValor(),
                input.getDataHora()
        );
    }

    private void salvarTransacao(TransacaoEntity transacao) {
        var portInput = SalvarTransacaoConsumerPort.SalvarTransacaoPortInput.builder()
                .transacao(transacao)
                .build();

        salvarTransacaoConsumerPort.executar(portInput);
    }
}
