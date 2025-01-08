package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptions.EntidadeNaoEncontradaException;
import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UsuarioService usuarioService;


    public List<Hotel> listarHoteis() {
        return hotelRepository.findAll();
    }

    public Hotel buscarHotel(Integer hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Hotel de id " + hotelId + " não encontrado"));
    }

    public Hotel salvarHotel(Hotel hotel) {
        Set<Usuario> donos = new HashSet<>();
        for (Usuario dono: hotel.getDonos()) {
            Usuario usuario = usuarioService.buscarPorId(dono.getId());
            donos.add(usuario);
        }

        hotel.setDonos(donos);
        return hotelRepository.save(hotel);
    }

    public void excluirHotel(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}