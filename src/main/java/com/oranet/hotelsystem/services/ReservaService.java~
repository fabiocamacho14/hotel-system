package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptions.EntidadeNaoEncontradaException;
import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.model.Reserva;
import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.repository.QuartoRepository;
import com.oranet.hotelsystem.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Reserva fazerReserva(Usuario usuario, Reserva reserva) {
        Integer hotelId = reserva.getHotel().getId();
        Hotel hotel = hotelService.buscarHotel(hotelId);
        reserva.setHotel(hotel);

        Quarto quarto = quartoRepository.findByCodigoQuartoAndHotel(
                reserva.getQuarto().getCodigoQuarto(),
                hotel
        ).orElseThrow(
                () -> new EntidadeNaoEncontradaException(
                        "Quarto de codigo " + reserva.getQuarto().getCodigoQuarto() +
                        " não encontrado no hotel de id " + hotelId)

        );

        reserva.setQuarto(quarto);

        reserva.setCodigoReserva(gerarStringAleatoria());

        Usuario usuarioTeste = usuarioService.buscarPorId(1);
        reserva.setUsuario(usuarioTeste);

        return reservaRepository.save(reserva);
    }

    private String gerarStringAleatoria() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            codigo.append(characters.charAt(index));
        }
        return codigo.toString();
    }

}
