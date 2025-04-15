package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.CriteriosNaoCorrespondidosException;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TransacaoEntityImpl extends TransacaoEntity {
    public TransacaoEntityImpl() {
        this.id = UUID.randomUUID();
    }

    public TransacaoEntityImpl(UUID id) {
        this.id = id;
    }

    @Override
    public void comValor(double valor) {
        if (valor < 0) {
            throw new CriteriosNaoCorrespondidosException("valor", valor);
        }

        this.valor = valor;
    }

    @Override
    public void comHora(OffsetDateTime dataHora) {
        if (dataHora.isAfter(OffsetDateTime.now())) {
            throw new CriteriosNaoCorrespondidosException("dataHora", dataHora.toString());
        }

        this.dataHora = dataHora;
    }
}
