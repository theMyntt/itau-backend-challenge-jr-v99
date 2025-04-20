package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes;

import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.io.EstatisticasRecentesUseCaseOutput;

public abstract class EstatisticasRecentesUseCase {
    public abstract EstatisticasRecentesUseCaseOutput executar(long segundos);
    protected abstract EstatisticasRecentesUseCaseOutput aplicarLogicaInterna(long segundos);
}
