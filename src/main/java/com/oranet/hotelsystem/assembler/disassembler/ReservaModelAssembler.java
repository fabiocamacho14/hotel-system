package com.oranet.hotelsystem.assembler.disassembler;

import com.oranet.hotelsystem.model.Reserva;
import com.oranet.hotelsystem.model.dto.ReservaModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ReservaModel toModel(Reserva reserva) {
        return modelMapper.map(reserva, ReservaModel.class);
    }

    public List<ReservaModel> toCollectionModel(List<Reserva> reservas) {
        return reservas.stream()
                .map(this::toModel)
                .toList();
    }

}
