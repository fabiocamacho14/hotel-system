package com.oranet.hotelsystem.model.dto.input;

import com.oranet.hotelsystem.model.dto.ContatoModel;
import com.oranet.hotelsystem.model.dto.EnderecoModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class HotelInputModel {

    private String nome;

    private String descricao;

    private EnderecoModel endereco;

    private ContatoModel contato;

    private Set<UsuarioIdInput> donos;
}
