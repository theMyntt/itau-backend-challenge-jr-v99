package com.gabrielaraujo.v99_itau_challenge_jr.controllers.estatisticas_recentes;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.EstatisticasRecentesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@Tag(name = "Estatísticas", description = "Estatísticas da Aplicação e das Transações")
public class EstatisticasRecentesController {
    private final EstatisticasRecentesUseCase estatisticasRecentesUseCase;
    private final long MINUTO = 60;

    public EstatisticasRecentesController(EstatisticasRecentesUseCase estatisticasRecentesUseCase) {
        this.estatisticasRecentesUseCase = estatisticasRecentesUseCase;
    }

    @GetMapping("/estatistica")
    @Operation(summary = "Gera estatísticas das transações do último minuto")
    public ResponseEntity<DoubleSummaryStatistics> performarUltimoMinuto() {
        var resultado = estatisticasRecentesUseCase.executar(MINUTO);
        return ResponseEntity.status(200).body(resultado.getEstatisticas());
    }

    @GetMapping("/estatistica/{limite}")
    @Operation(summary = "Gera estatísticas das transações com base no limite de tempo (em segundos) que usuário decidir")
    public ResponseEntity<DoubleSummaryStatistics> performarMinutoCustomizavel(
            @PathVariable long limite) {
        var resultado = estatisticasRecentesUseCase.executar(limite);
        return ResponseEntity.status(200).body(resultado.getEstatisticas());
    }
}
