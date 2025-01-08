package com.oranet.hotelsystem.assembler;

import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.model.dto.QuartoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuartoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public QuartoModel toModel(Quarto quarto) {
        return modelMapper.map(quarto, QuartoModel.class);
    }

    public List<QuartoModel> toCollectionModel(List<Quarto> quartos) {
        return quartos.stream()
                .map(this::toModel)
                .toList();
    }
}
