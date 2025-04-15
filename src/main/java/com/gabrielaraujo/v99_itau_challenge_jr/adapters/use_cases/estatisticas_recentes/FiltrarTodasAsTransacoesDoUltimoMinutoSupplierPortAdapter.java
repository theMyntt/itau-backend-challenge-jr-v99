package com.gabrielaraujo.v99_itau_challenge_jr.adapters.use_cases.estatisticas_recentes;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories.TransacaoRepository;
import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.mappers.TransacaoMapper;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.estatisticas_recentes.implementations.ports.FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

public class FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortAdapter implements FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPort {
    private final TransacaoRepository transacaoRepository;

    public FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortAdapter(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortOuput executar() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        var transacoes = transacaoRepository.listarTodas().stream()
                .map(TransacaoMapper::toEntityFormat)
                .filter(e -> e.getDataHora().isAfter(limite))
                .toList();

        return FiltrarTodasAsTransacoesDoUltimoMinutoSupplierPortOuput.builder()
                .transacoes(transacoes)
                .build();
    }
}
