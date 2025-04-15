package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.EstatisticasRecentesUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations.ports.FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.io.EstatisticasRecentesUseCaseOutput;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class EstatisticasRecentesUseCaseImpl extends EstatisticasRecentesUseCase {
    private final FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort;

    public EstatisticasRecentesUseCaseImpl(FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort) {
        this.filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort = filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort;
    }

    @Override
    public EstatisticasRecentesUseCaseOutput executar() {
        return aplicarLogicaInterna();
    }

    @Override
    protected EstatisticasRecentesUseCaseOutput aplicarLogicaInterna() {
        var transacoes = filtrarTransacoesRecentes();
        var estatisticas = calcularEstaticasDas(transacoes);

        return EstatisticasRecentesUseCaseOutput.builder()
                .estatisticas(estatisticas)
                .build();
    }

    private List<TransacaoEntity> filtrarTransacoesRecentes() {
        var portOutput = filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort.executar();
        return portOutput.getTransacoes();
    }

    private DoubleSummaryStatistics calcularEstaticasDas(List<TransacaoEntity> transacoes) {
        return transacoes.stream()
                .mapToDouble(TransacaoEntity::getValor)
                .summaryStatistics();
    }
}
