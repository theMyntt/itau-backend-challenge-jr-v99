package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.outputs;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Builder
public class CriarTransacaoUseCaseOutput {
    private int codigoHttp;
}
