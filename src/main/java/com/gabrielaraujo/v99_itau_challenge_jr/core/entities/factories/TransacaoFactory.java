package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations.TransacaoEntityImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransacaoFactory {
    public static TransacaoEntity of(double valor, OffsetDateTime dataHota) {
        var entity = new TransacaoEntityImpl();

        entity.comValor(valor);
        entity.comHora(dataHota);

        return entity;
    }
}
