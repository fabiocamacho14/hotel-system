package com.oranet.hotelsystem.repository;

import com.oranet.hotelsystem.model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

    Optional<Reserva> findByCodigoReserva(String codigoReserva);

    Optional<Reserva> findById(Integer reservaId);
}
