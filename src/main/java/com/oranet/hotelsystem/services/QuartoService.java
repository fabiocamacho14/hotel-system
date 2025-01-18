package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptions.EntidadeNaoEncontradaException;
import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.model.Reserva;
import com.oranet.hotelsystem.repository.QuartoRepository;
import com.oranet.hotelsystem.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ReservaRepository reservaRepository;

    public Quarto buscarPorId(Integer quartoId) {
        return quartoRepository.findById(quartoId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Quarto de id " + quartoId + " não encontrado"));
    }

    public Quarto buscarPorCodigoQuarto(String codigoQuarto, Hotel hotel) {
        Integer hotelId = hotel.getId();
        Hotel hotelBusca = hotelService.buscarHotel(hotelId);

        Quarto quarto = quartoRepository.findByCodigoQuartoAndHotel(
                codigoQuarto,
                hotel
        ).orElseThrow(
                () -> new EntidadeNaoEncontradaException(
                        "Quarto de codigo " + codigoQuarto +
                                " não encontrado no hotel de id " + hotelId)

        );
        return quarto;
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

    public List<LocalDate> buscarDatasDisponiveisNoMes(Integer hotelId, String codigoQuarto, Integer mes, Integer ano) {
        YearMonth yearMonth = YearMonth.of(ano, mes);
        LocalDate primeiroDiaDoMes = yearMonth.atDay(1);
        LocalDate ultimoDiaDoMes = yearMonth.atEndOfMonth();
        Hotel hotel = hotelService.buscarHotel(hotelId);

        List<Reserva> reservas = reservaRepository.buscarReservasNoMesQuarto(hotel, codigoQuarto, mes, ano);

        List<LocalDate> todasAsDatas = primeiroDiaDoMes.datesUntil(ultimoDiaDoMes).toList();

        return todasAsDatas.stream()
                .filter(data -> reservas.stream()
                        .noneMatch(reserva -> !data.isBefore(reserva.getDataEntrada() ) && !data.isAfter(reserva.getDataSaida())))
                .toList();
    }
}
