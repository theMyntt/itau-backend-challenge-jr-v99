package com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories.implementation;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories.TransacaoRepository;
import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.TransacaoTableRow;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoRepositoryImpl extends TransacaoRepository {
    @Override
    public TransacaoTableRow salvarNova(TransacaoTableRow transacao) {
        this.transacoes.add(transacao);
        return transacao;
    }

    @Override
    public List<String> deletarTodas() {
        var idQueVaoSerApagados = this.transacoes.stream()
                .map(TransacaoTableRow::getId)
                .collect(Collectors.toList());

        this.transacoes = new ArrayList<>();

        return idQueVaoSerApagados;
    }

    @Override
    public List<TransacaoTableRow> listarTodas() {
        return this.transacoes;
    }
}
