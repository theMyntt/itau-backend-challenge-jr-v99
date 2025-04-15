package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions;

public class NenhumaTransacaoEncontradaException extends RuntimeException {
    public NenhumaTransacaoEncontradaException() {
        super("No recent transactions found");
    }
}
