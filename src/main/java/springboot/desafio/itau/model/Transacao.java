package springboot.desafio.itau.model;

import java.time.OffsetDateTime;

public class Transacao {
    private final double valor;
    private final OffsetDateTime dataHora;

    public Transacao(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    //Getters
    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}