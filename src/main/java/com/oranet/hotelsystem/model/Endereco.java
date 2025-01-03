package com.oranet.hotelsystem.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    @Column(name = "cep", length = 255, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 255, nullable = false)
    private String logradouro;

    @Column(name = "numero", length = 255, nullable = false)
    private String numero;

    @Column(name = "complemento", length = 255, nullable = false)
    private String complemento;

    @Column(name = "bairro", length = 255, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 255, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 255, nullable = false)
    private String estado;
}
