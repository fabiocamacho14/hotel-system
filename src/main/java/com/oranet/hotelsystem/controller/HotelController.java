package com.oranet.hotelsystem.controller;

import com.oranet.hotelsystem.assembler.HotelModelAssembler;
import com.oranet.hotelsystem.assembler.disassembler.HotelInputModelDisassembler;
import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.dto.HotelModel;
import com.oranet.hotelsystem.model.dto.input.HotelInputModel;
import com.oranet.hotelsystem.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelModelAssembler hotelModelAssembler;

    @Autowired
    private HotelInputModelDisassembler hotelInputModelDisassembler;

    @GetMapping
    public List<HotelModel> listarHoteis() {
        return hotelModelAssembler.toCollectionModel(hotelService.listarHoteis());
    }

    @GetMapping("/{hotelId}")
    public HotelModel buscarHotel(@PathVariable Integer hotelId) {
        return hotelModelAssembler.toModel(hotelService.buscarHotel(hotelId));
    }

    @PostMapping
    public HotelModel salvarHotel(@RequestBody HotelInputModel hotelInputModel) {
        Hotel hotelSalvar = hotelInputModelDisassembler.toDomainObject(hotelInputModel);
        return hotelModelAssembler.toModel(hotelService.salvarHotel(hotelSalvar));
    }

    @PutMapping("/{hotelId}")
    public HotelModel atualizarHotel(@PathVariable Integer hotelId, @RequestBody HotelInputModel hotelInputModel) {
        Hotel hotel = hotelService.buscarHotel(hotelId);
        hotelInputModelDisassembler.copyToDomainObject(hotelInputModel, hotel);
        return hotelModelAssembler.toModel(hotelService.salvarHotel(hotel));
    }

    @DeleteMapping("/{hotelId}")
    public void excluirHotel(@PathVariable Integer hotelId) {
        hotelService.excluirHotel(hotelId);
    }
}
