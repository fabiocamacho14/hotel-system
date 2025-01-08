package com.oranet.hotelsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartoModel {

    private Integer id;

    private String codigoQuarto;

    private String tipoQuarto;

    private Boolean temBanheiro;

    private Double valorDiaria;

    private HotelModel hotel;

}
