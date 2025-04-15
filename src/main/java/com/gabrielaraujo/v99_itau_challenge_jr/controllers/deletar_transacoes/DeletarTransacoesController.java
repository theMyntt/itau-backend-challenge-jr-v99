package com.gabrielaraujo.v99_itau_challenge_jr.controllers.deletar_transacoes;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.DeletarTransacoesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Transações", description = "Criação e Delete de Transações")
public class DeletarTransacoesController {
    private final DeletarTransacoesUseCase deletarTransacoesUseCase;

    public DeletarTransacoesController(DeletarTransacoesUseCase deletarTransacoesUseCase) {
        this.deletarTransacoesUseCase = deletarTransacoesUseCase;
    }

    @DeleteMapping("/transacao")
    @Operation(summary = "Deleta todas as Transações")
    public ResponseEntity<?> performar() {
        deletarTransacoesUseCase.executar();
        return ResponseEntity.status(200).build();
    }
}
