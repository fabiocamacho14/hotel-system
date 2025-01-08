package com.oranet.hotelsystem.assembler;

import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.model.dto.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toModel)
                .toList();
    }
}
