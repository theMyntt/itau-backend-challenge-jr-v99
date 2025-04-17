package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.CriteriosNaoCorrespondidosException;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TransacaoEntityImpl extends TransacaoEntity {
    public TransacaoEntityImpl(double valor, OffsetDateTime dataHora) {
        this.id = UUID.randomUUID();
        validarValor(valor);
        validarDataHora(dataHora);
    }

    public TransacaoEntityImpl(UUID id, double valor, OffsetDateTime dataHora) {
        this.id = id;
        validarValor(valor);
        validarDataHora(dataHora);
    }

    @Override
    protected void validarValor(double valor) {
        if (valor < 0) {
            throw new CriteriosNaoCorrespondidosException("valor", valor);
        }

        this.valor = valor;
    }

    @Override
    protected void validarDataHora(OffsetDateTime dataHora) {
        if (dataHora.isAfter(OffsetDateTime.now())) {
            throw new CriteriosNaoCorrespondidosException("dataHora", dataHora.toString());
        }

        this.dataHora = dataHora;
    }
}
