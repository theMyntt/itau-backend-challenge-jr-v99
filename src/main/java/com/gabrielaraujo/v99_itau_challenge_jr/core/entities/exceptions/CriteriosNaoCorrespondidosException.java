package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions;

public class CriteriosNaoCorrespondidosException extends RuntimeException {
    public CriteriosNaoCorrespondidosException(String criteria, String value) {
        super("The criteria: " + criteria + " has the value: " + value + " which is invalid");
    }

    public CriteriosNaoCorrespondidosException(String criteria, double value) {
        super("The criteria: " + criteria + " has the value: " + value + " which is invalid");
    }
}
