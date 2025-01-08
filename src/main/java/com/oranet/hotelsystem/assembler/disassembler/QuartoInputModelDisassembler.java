package com.oranet.hotelsystem.assembler.disassembler;

import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.model.dto.input.QuartoInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartoInputModelDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Quarto toDomainObject(QuartoInputModel quartoInputModel) {
        return modelMapper.map(quartoInputModel, Quarto.class);
    }

    public void copyToDomainObject(QuartoInputModel quartoInputModel, Quarto quarto) {
        modelMapper.map(quartoInputModel, quarto);
    }
}
