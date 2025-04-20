package com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations.ports;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public interface FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort {
    FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortOuput executar(long segundos);
    @Getter
    @Builder
    class FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortOuput {
        private List<TransacaoEntity> transacoes;
    }
}
