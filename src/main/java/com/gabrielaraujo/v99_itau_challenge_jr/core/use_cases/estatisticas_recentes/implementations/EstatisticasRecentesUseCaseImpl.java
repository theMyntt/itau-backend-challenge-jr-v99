package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.EstatisticasRecentesUseCase;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations.ports.FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.io.EstatisticasRecentesUseCaseOutput;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticasRecentesUseCaseImpl extends EstatisticasRecentesUseCase {
    private final FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort;

    public EstatisticasRecentesUseCaseImpl(FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort) {
        this.filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort = filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort;
    }

    @Override
    public EstatisticasRecentesUseCaseOutput executar(long segundos) {
        return aplicarLogicaInterna(segundos);
    }

    @Override
    protected EstatisticasRecentesUseCaseOutput aplicarLogicaInterna(long segundos) {
        var transacoes = filtrarTransacoesRecentes(segundos);
        var estatisticas = calcularEstaticasDas(transacoes);

        return EstatisticasRecentesUseCaseOutput.builder()
                .estatisticas(estatisticas)
                .build();
    }

    private List<TransacaoEntity> filtrarTransacoesRecentes(long segundos) {
        var portOutput = filtrarTodasAsTransacoesDoUltimoMinutoSupplierPort.executar(segundos);
        return portOutput.getTransacoes();
    }

    private DoubleSummaryStatistics calcularEstaticasDas(List<TransacaoEntity> transacoes) {
        return transacoes.stream()
                .mapToDouble(TransacaoEntity::getValor)
                .summaryStatistics();
    }
}
