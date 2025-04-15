package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;

import java.time.OffsetDateTime;

// TODO: Refactor for Exclusive Exceptions
public class TransacaoEntityImpl extends TransacaoEntity {
    @Override
    public void comValor(double valor) {
        if (valor < 0) {
            throw new RuntimeException("");
        }

        this.valor = valor;
    }

    @Override
    public void comHora(OffsetDateTime dataHora) {
        if (dataHora.isAfter(this.dataHora)) {
            throw new RuntimeException("");
        }

        this.dataHora = dataHora;
    }
}
