package com.oranet.hotelsystem.model.dto;

import com.oranet.hotelsystem.model.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservaModel {

    private Integer id;

    private String codigoReserva;

    private LocalDate dataEntrada;

    private LocalDate dataSaida;

    private QuartoModel quarto;

    private UsuarioModel usuario;

    private FormaPagamento formaPagamento;

    private Double valorTotal;

    private String observacoes;

}
