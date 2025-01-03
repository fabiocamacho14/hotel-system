package com.oranet.hotelsystem.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contato {

    @Column(name = "numero_telefone", length = 20, nullable = false)
    private String numeroTelefone;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "numero_residencial", length = 20, nullable = false)
    private String numeroResidencial;
}
