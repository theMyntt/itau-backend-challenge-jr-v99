package com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.mappers;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.TransacaoTableRow;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.TransacaoEntity;
import com.gabrielaraujo.v99_itau_challenge_jr.core.entities.factories.TransacaoFactory;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TransacaoMapper {
    public static TransacaoEntity toEntityFormat(TransacaoTableRow table) {
        return TransacaoFactory.of(
                UUID.fromString(table.getId()),
                table.getValor(),
                OffsetDateTime.parse(table.getDataHora())
        );
    }

    public static TransacaoTableRow toTableRowFormat(TransacaoEntity entity) {
        return new TransacaoTableRow(
                entity.getId().toString(),
                entity.getValor(),
                entity.getDataHora().toString()
        );
    }
}
