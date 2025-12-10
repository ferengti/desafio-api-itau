
package springboot.desafio.itau.dto;

import javax.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransacaoRequest {
    @NotNull
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;

    //Getters
    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}