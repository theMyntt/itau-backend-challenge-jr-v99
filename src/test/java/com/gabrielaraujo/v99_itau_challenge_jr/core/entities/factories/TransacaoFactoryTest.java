package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations.TransacaoEntityImpl;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoFactoryTest {
    private final OffsetDateTime DATA_HORA = OffsetDateTime.now();
    private final double VALOR = 10;
    private final UUID ID_TRANSACAO = UUID.randomUUID();

    @Test
    void comDataEValor_criarTransacao() {
        var transacao = TransacaoFactory.of(VALOR, DATA_HORA);

        assertEquals(TransacaoEntityImpl.class, transacao.getClass());
        assertEquals(DATA_HORA, transacao.getDataHora());
        assertEquals(VALOR, transacao.getValor());
    }

    @Test
    void comIdDataEValor_criarTransacao() {
        var transacao = TransacaoFactory.of(ID_TRANSACAO, VALOR, DATA_HORA);

        assertEquals(TransacaoEntityImpl.class, transacao.getClass());
        assertEquals(ID_TRANSACAO, transacao.getId());
        assertEquals(DATA_HORA, transacao.getDataHora());
        assertEquals(VALOR, transacao.getValor());
    }
}