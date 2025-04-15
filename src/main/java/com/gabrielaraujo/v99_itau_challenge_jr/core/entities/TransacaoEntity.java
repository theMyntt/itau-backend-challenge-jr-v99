package com.gabrielaraujo.v99_itau_challenge_jr.core.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class TransacaoEntity {
    protected UUID id;
    protected double valor;
    protected OffsetDateTime dataHora;

    public abstract void comValor(double valor);
    public abstract void comHora(OffsetDateTime dataHora);
}
