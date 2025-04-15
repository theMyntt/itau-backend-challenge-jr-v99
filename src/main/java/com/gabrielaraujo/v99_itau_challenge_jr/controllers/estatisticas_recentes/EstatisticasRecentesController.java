package com.gabrielaraujo.v99_itau_challenge_jr.controllers.estatisticas_recentes;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.EstatisticasRecentesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
public class EstatisticasRecentesController {
    private final EstatisticasRecentesUseCase estatisticasRecentesUseCase;

    public EstatisticasRecentesController(EstatisticasRecentesUseCase estatisticasRecentesUseCase) {
        this.estatisticasRecentesUseCase = estatisticasRecentesUseCase;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<DoubleSummaryStatistics> performar() {
        var resultado = estatisticasRecentesUseCase.executar();
        return ResponseEntity.status(200).body(resultado.getEstatisticas());
    }
}
