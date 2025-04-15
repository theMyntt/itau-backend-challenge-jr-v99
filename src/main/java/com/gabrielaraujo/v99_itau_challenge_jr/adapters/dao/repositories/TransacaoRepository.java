package com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.TransacaoTableRow;

import java.util.ArrayList;
import java.util.List;

public abstract class TransacaoRepository {
    protected List<TransacaoTableRow> transacoes = new ArrayList<>();

    protected abstract TransacaoTableRow salvarNova(TransacaoTableRow transacao);
    protected abstract List<String> deletarTodas();
    protected abstract List<TransacaoTableRow> listarTodas();
}
