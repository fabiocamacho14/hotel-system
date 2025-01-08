package com.oranet.hotelsystem.assembler;

import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.dto.HotelModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public HotelModel toModel(Hotel hotel) {
        return modelMapper.map(hotel, HotelModel.class);
    }

    public List<HotelModel> toCollectionModel(List<Hotel> hoteis) {
        return hoteis.stream().map(this::toModel).toList();
    }
}
