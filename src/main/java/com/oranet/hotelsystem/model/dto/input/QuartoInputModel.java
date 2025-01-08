package com.oranet.hotelsystem.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartoInputModel {

    private String codigoQuarto;

    private String tipoQuarto;

    private Boolean temBanheiro;

    private Double valorDiaria;

    private HotelIdInput hotel;

}
