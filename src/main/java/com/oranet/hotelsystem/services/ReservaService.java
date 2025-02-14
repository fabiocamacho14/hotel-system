package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptionhandler.NegocioException;
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

import java.time.LocalDate;
import java.util.List;

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

    @Autowired
    private QuartoService quartoService;

    @Transactional
    public Reserva fazerReserva(Usuario usuario, Reserva reserva) {
        Integer hotelId = reserva.getHotel().getId();

        Integer mesEntrada = reserva.getDataEntrada().getMonthValue();
        Integer mesSaida = reserva.getDataSaida().getMonthValue();
        Integer anoEntrada = reserva.getDataEntrada().getYear();
        Integer anoSaida =  reserva.getDataSaida().getYear();

        List<LocalDate> datasDisponiveisMesEntrada =  quartoService.buscarDatasDisponiveisNoMes(hotelId, reserva.getQuarto().getCodigoQuarto(), mesEntrada, anoEntrada);
        List<LocalDate> datasDisponiveisMesSaida =  quartoService.buscarDatasDisponiveisNoMes(hotelId, reserva.getQuarto().getCodigoQuarto(), mesSaida, anoSaida);

        List<LocalDate> datasDaReserva = reserva.getDataEntrada().datesUntil(reserva.getDataSaida()).toList();

        for (LocalDate data : datasDaReserva) {
            if (!datasDisponiveisMesEntrada.contains(data) || !datasDisponiveisMesSaida.contains(data)) {
                throw new NegocioException("Não é possível fazer a reserva. Uma das datas está indisponível.");
            }
        }

        if (!datasDisponiveisMesEntrada.contains(reserva.getDataEntrada()) || !datasDisponiveisMesSaida.contains(reserva.getDataSaida())) {
            throw new NegocioException("Não é possível fazer a reserva. Uma das datas está indisponível.");
        }
        quartoService.buscarDatasDisponiveisNoMes(hotelId, reserva.getQuarto().getCodigoQuarto(), mesSaida, mesSaida);


        Hotel hotel = hotelService.buscarHotel(hotelId);
        reserva.setHotel(hotel);

        Quarto quarto = quartoService.buscarPorCodigoQuarto(reserva.getQuarto().getCodigoQuarto(), hotel);

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
