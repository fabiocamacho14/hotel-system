package com.oranet.hotelsystem.assembler.disassembler;

import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.model.dto.input.UsuarioInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInputModelDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Usuario toDomainObject(UsuarioInputModel usuarioInputModel) {
        return modelMapper.map(usuarioInputModel, Usuario.class);
    }

    public void copyToDomainObject(UsuarioInputModel usuarioInputModel, Usuario usuario) {
        modelMapper.map(usuarioInputModel, usuario);
    }
}
