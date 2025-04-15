package com.gabrielaraujo.v99_itau_challenge_jr.controllers;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.NenhumaTransacaoEncontradaException;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.OneOrMoreCriteriaWereNotMetException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(OneOrMoreCriteriaWereNotMetException.class)
    public ResponseEntity<?> manipularExcecao(OneOrMoreCriteriaWereNotMetException excecao) {
        return ResponseEntity.status(422).build();
    }

    @ExceptionHandler(NenhumaTransacaoEncontradaException.class)
    public ResponseEntity<?> manipularNotFoundExcecao(NenhumaTransacaoEncontradaException excecao) {
        return ResponseEntity.status(404).build();
    }
}
