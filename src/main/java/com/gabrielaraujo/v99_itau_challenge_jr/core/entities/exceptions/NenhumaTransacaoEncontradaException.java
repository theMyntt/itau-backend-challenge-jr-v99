package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions;

public class NenhumaTransacaoEncontradaException extends RuntimeException {
    public NenhumaTransacaoEncontradaException() {
        super("Nenhuma Transação Encontrada");
    }
}
