package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.implementations;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.CriteriosNaoCorrespondidosException;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoEntityImplTest {
    private TransacaoEntity criarTransacao(double valor, OffsetDateTime dataHora) {
        return new TransacaoEntityImpl(valor, dataHora);
    }

    @Test
    void seOValorForMenorQueZero_tacarExeccao() {
        var resultado = assertThrows(CriteriosNaoCorrespondidosException.class, () -> criarTransacao(-1, OffsetDateTime.now()));

        assertEquals(resultado.getMessage(), "The criteria: valor has the value: -1.0 which is invalid");
    }

    @Test
    void seADataHoraForDepoisQueAgora_tacarExeccao() {
        var data = OffsetDateTime.now().plusDays(2);
        var resultado = assertThrows(CriteriosNaoCorrespondidosException.class, () -> criarTransacao(5, data));

        assertEquals(resultado.getMessage(), "The criteria: dataHora has the value: " + data + " which is invalid");
    }

    @Test
    void seADataEOValorForValidor_criarTransacao() {
        var data = OffsetDateTime.now();
        var transacao = criarTransacao(10, data);

        assertEquals(TransacaoEntityImpl.class, transacao.getClass());
        assertEquals(10, transacao.getValor());
        assertEquals(data, transacao.getDataHora());
    }
}