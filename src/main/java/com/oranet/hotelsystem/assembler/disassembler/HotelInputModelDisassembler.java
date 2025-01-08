package com.oranet.hotelsystem.assembler.disassembler;

import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.dto.input.HotelInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelInputModelDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Hotel toDomainObject(HotelInputModel hotelInputModel) {
        return modelMapper.map(hotelInputModel, Hotel.class);
    }

    public void copyToDomainObject(HotelInputModel hotelInputModel, Hotel hotel) {
        modelMapper.map(hotelInputModel, hotel);
    }
}
