package com.oranet.hotelsystem.model.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioInputModel {

    private String nome;

    private String cpf;

    private String rg;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimento;

    private EnderecoInputModel endereco;

    private ContatoInputModel contato;

    private String nacionalidade;

}
