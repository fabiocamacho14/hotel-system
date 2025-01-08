package com.oranet.hotelsystem.controller;

import com.oranet.hotelsystem.assembler.disassembler.ReservaInputModelDisassembler;
import com.oranet.hotelsystem.assembler.disassembler.ReservaModelAssembler;
import com.oranet.hotelsystem.model.Reserva;
import com.oranet.hotelsystem.model.dto.ReservaModel;
import com.oranet.hotelsystem.model.dto.input.ReservaInputModel;
import com.oranet.hotelsystem.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ReservaInputModelDisassembler reservaInputModelDisassembler;

    @Autowired
    private ReservaModelAssembler reservaModelAssembler;

    @PostMapping
    public ReservaModel fazerReserva(@RequestBody ReservaInputModel reservaInputModel) {
        Reserva reserva = reservaInputModelDisassembler.toDomainObject(reservaInputModel);
        return reservaModelAssembler.toModel(reservaService.fazerReserva(null, reserva));
    }
}
