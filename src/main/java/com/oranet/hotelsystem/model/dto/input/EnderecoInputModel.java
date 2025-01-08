package com.oranet.hotelsystem.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInputModel {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

}
