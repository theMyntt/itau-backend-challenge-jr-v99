package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CriarTransacaoUseCaseInput {
    private Double valor;
    private OffsetDateTime dataHora;
}
