package springboot.desafio.itau.service;

import java.time.OffsetDateTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springboot.desafio.itau.model.Transacao;

@Service
public class TransacaoService {
    private boolean validacaoDataHora;
    private boolean validacaoValor;
    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public ResponseEntity<Void> addTransacao(Transacao transacao) {
        transacoes.add(transacao);
        return validaTransacao(transacao);
    }

    public ResponseEntity<Void> validaTransacao(Transacao transacao) {
        validacaoDataHora = validaDataHora(transacao.getDataHora());
        validacaoValor = validaValor(transacao.getValor());
        if (validacaoDataHora || validacaoValor) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public boolean validaDataHora(OffsetDateTime dataHora) {
        OffsetDateTime dataHoraAtual = OffsetDateTime.now();
        return dataHora.isAfter(dataHoraAtual);
    }

    public boolean validaValor(double valor) {
        return valor <= 0;
    }
}