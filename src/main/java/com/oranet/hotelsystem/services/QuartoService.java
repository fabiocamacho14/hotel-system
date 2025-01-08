package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptions.EntidadeNaoEncontradaException;
import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelService hotelService;

    public Quarto buscarPorId(Integer quartoId) {
        return quartoRepository.findById(quartoId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Quarto de id " + quartoId + " não encontrado"));
    }

    public List<Quarto> listarQuartos() {
        return quartoRepository.findAll();
    }

    public Quarto salvarQuarto(Quarto quarto) {
        Integer hotelId = quarto.getHotel().getId();
        Hotel hotel = hotelService.buscarHotel(hotelId);

        quarto.setHotel(hotel);
        return quartoRepository.save(quarto);
    }

    public void excluirQuarto(Integer quartoId) {
        quartoRepository.deleteById(quartoId);
    }
}
