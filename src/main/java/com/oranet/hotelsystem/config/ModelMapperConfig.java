package com.oranet.hotelsystem.config;

import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.model.dto.UsuarioResumidoModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Usuario.class, UsuarioResumidoModel.class)
                .addMapping(Usuario::getId, UsuarioResumidoModel::setId)
                .addMapping(Usuario::getNome, UsuarioResumidoModel::setNome)
                .addMapping(Usuario::getCpf, UsuarioResumidoModel::setCpf);

        return modelMapper;
    }
}
