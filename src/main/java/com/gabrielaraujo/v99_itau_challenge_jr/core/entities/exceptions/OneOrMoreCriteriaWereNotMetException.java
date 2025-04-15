package com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions;

public class OneOrMoreCriteriaWereNotMetException extends RuntimeException {
    public OneOrMoreCriteriaWereNotMetException(String criteria, String value) {
        super("The criteria: " + criteria + " has the value: " + value + " which is invalid");
    }

    public OneOrMoreCriteriaWereNotMetException(String criteria, double value) {
        super("The criteria: " + criteria + " has the value: " + value + " which is invalid");
    }
}
