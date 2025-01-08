package com.oranet.hotelsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioModel {

    private Integer id;

    private String nome;

    private Integer idade;

    private String cpf;

    private LocalDate dataNascimento;

    private EnderecoModel endereco;

    private ContatoModel contato;

    private String nacionalidade;

}
