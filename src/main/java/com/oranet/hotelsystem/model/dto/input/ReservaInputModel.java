package com.oranet.hotelsystem.model.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oranet.hotelsystem.model.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservaInputModel {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataEntrada;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataSaida;

    private HotelIdInput hotel;

    private QuartoCodigoInputModel quarto;

    private FormaPagamento formaPagamento;

    private String observacoes;
}
