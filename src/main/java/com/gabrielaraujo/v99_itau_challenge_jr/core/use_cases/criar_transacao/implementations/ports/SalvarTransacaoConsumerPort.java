package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations.ports;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import lombok.Builder;
import lombok.Getter;

public interface SalvarTransacaoConsumerPort {
    SalvarTransacaoPortOutput executar(SalvarTransacaoPortInput input);

    @Builder
    @Getter
    class SalvarTransacaoPortInput {
        private TransacaoEntity transacao;
    }

    @Builder
    @Getter
    class SalvarTransacaoPortOutput {
        private TransacaoEntity transacao;
    }
}
