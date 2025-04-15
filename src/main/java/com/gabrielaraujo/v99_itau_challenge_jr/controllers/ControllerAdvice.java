package com.gabrielaraujo.v99_itau_challenge_jr.controllers;

import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.NenhumaTransacaoEncontradaException;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.exceptions.CriteriosNaoCorrespondidosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(CriteriosNaoCorrespondidosException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<?> manipularCriteriosNaoCorrespondidosExcecao(CriteriosNaoCorrespondidosException excecao) {
        log.error(excecao.getMessage());
        return ResponseEntity.status(422).build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> manipularExcecoes(RuntimeException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(500).build();
    }

    @ExceptionHandler(NenhumaTransacaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> manipularNenhumaTransacaoEcontradaExcecao(NenhumaTransacaoEncontradaException excecao) {
        log.error(excecao.getMessage());
        return ResponseEntity.status(404).build();
    }
}
