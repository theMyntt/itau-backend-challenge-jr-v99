package com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TransacaoTableRow {
    private final String id;
    private final Double valor;
    private final String dataHora;
}
