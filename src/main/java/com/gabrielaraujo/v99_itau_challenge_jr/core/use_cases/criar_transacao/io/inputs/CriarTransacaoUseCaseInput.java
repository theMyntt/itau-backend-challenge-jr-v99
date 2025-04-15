package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CriarTransacaoUseCaseInput {
    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;
}
