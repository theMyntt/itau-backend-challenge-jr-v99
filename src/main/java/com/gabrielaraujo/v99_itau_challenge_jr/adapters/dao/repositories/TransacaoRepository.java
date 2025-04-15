package com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.TransacaoTableRow;

import java.util.ArrayList;
import java.util.List;

public abstract class TransacaoRepository {
    protected List<TransacaoTableRow> transacoes = new ArrayList<>();

    public abstract TransacaoTableRow salvarNova(TransacaoTableRow transacao);
    public abstract List<String> deletarTodas();
    public abstract List<TransacaoTableRow> listarTodas();
}
