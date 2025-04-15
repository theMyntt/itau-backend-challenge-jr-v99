package com.gabrielaraujo.v99_itau_challenge_jr.controllers.deletar_transacoes;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.deletar_transacoes.DeletarTransacoesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

@Controller
public class DeletarTransacoesController {
    private final DeletarTransacoesUseCase deletarTransacoesUseCase;

    public DeletarTransacoesController(DeletarTransacoesUseCase deletarTransacoesUseCase) {
        this.deletarTransacoesUseCase = deletarTransacoesUseCase;
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> performar() {
        deletarTransacoesUseCase.executar();
        return ResponseEntity.status(200).build();
    }
}
