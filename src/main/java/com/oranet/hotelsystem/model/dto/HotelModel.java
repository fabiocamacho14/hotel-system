package com.oranet.hotelsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class HotelModel {

    private Integer id;

    private String nome;

    private String descricao;

    private EnderecoModel endereco;

    private ContatoModel contato;

    private Set<UsuarioModel> donos = new HashSet<UsuarioModel>();
}
