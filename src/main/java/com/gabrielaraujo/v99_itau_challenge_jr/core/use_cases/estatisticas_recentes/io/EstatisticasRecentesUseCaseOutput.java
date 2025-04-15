package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.io;

import lombok.Builder;
import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Builder
@Getter
public class EstatisticasRecentesUseCaseOutput {
    private DoubleSummaryStatistics estatisticas;
}
