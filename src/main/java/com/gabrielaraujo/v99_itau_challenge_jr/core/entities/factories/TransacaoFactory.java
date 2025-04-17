package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations.TransacaoEntityImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransacaoFactory {
    public static TransacaoEntity of(double valor, OffsetDateTime dataHota) {
        var entity = new TransacaoEntityImpl(valor, dataHota);

        return entity;
    }

    public static TransacaoEntity of(UUID id, double valor, OffsetDateTime dataHota) {
        var entity = new TransacaoEntityImpl(id, valor, dataHota);

        return entity;
    }
}
