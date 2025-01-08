package com.oranet.hotelsystem.assembler.disassembler;

import com.oranet.hotelsystem.model.Reserva;
import com.oranet.hotelsystem.model.dto.input.ReservaInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaInputModelDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Reserva toDomainObject(ReservaInputModel reservaInputModel) {
        return modelMapper.map(reservaInputModel, Reserva.class);
    }

    public void copyToDomainObject(ReservaInputModel reservaInputModel, Reserva reserva) {
        modelMapper.map(reservaInputModel, reserva);
    }
}

