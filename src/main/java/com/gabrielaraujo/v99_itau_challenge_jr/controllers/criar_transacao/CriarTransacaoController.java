package com.gabrielaraujo.v99_itau_challenge_jr.controllers.criar_transacao;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.CriarTransacaoUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.io.inputs.CriarTransacaoUseCaseInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Transações", description = "Criação e Delete de Transações")
public class CriarTransacaoController {
    private final CriarTransacaoUseCase criarTransacaoUseCase;

    public CriarTransacaoController(CriarTransacaoUseCase criarTransacaoUseCase) {
        this.criarTransacaoUseCase = criarTransacaoUseCase;
    }

    @PostMapping("/transacao")
    @Operation(summary = "Cria uma nova transação")
    public ResponseEntity<?> performar(@Valid @RequestBody CriarTransacaoUseCaseInput input) {
        var resultado = criarTransacaoUseCase.executar(input);
        return ResponseEntity.status(resultado.getCodigoHttp()).build();
    }
}
