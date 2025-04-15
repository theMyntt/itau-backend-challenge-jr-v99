package com.gabrielaraujo.v99_itau_challenge_jr.adapters.use_cases.criar_transacao;

import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.repositories.TransacaoRepository;
import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.TransacaoTableRow;
import com.gabrielaraujo.v99_itau_challenge_jr.adapters.dao.tables.mappers.TransacaoMapper;
import com.gabrielaraujo.v99_itau_challenge_jr.core.use_cases.criar_transacao.implementations.ports.SalvarTransacaoConsumerPort;
import org.springframework.stereotype.Service;

@Service
public class SalvarTransacaoConsumerPortAdapter implements SalvarTransacaoConsumerPort {
    private final TransacaoRepository transacaoRepository;

    public SalvarTransacaoConsumerPortAdapter(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public SalvarTransacaoPortOutput executar(SalvarTransacaoPortInput input) {
        var novaTransacao = extrairNoFormatoTableDo(input);
        novaTransacao = transacaoRepository.salvarNova(novaTransacao);

        return SalvarTransacaoPortOutput.builder()
                .transacao(TransacaoMapper.toEntityFormat(novaTransacao))
                .build();
    }

    private TransacaoTableRow extrairNoFormatoTableDo(SalvarTransacaoPortInput input) {
        return TransacaoMapper.toTableRowFormat(input.getTransacao());
    }
}
