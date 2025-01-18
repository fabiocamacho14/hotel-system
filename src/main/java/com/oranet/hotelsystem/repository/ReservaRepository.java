package com.oranet.hotelsystem.repository;

import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

    Optional<Reserva> findByCodigoReserva(String codigoReserva);

    Optional<Reserva> findById(Integer reservaId);

    @Query("select r from Reserva r " +
            "join Quarto q " +
            "on r.quarto.id = q.id " +
            "where (q.codigoQuarto = ?2 and q.hotel = ?1) " +
            "and ((extract(month from r.dataEntrada) = ?3 or extract(month from r.dataSaida) = ?3) " +
            "and (extract(year from r.dataEntrada) = ?4) or (extract(year from r.dataSaida) = ?4))")
    List<Reserva> buscarReservasNoMesQuarto(Hotel hotel, String codigoQuarto, Integer mes, Integer ano);
}
