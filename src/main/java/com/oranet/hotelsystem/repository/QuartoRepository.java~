package com.oranet.hotelsystem.repository;

import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Quarto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Integer> {

Optional<Quarto> findByCodigoQuartoAndHotel(String codigoQuarto, Hotel hotel);

    Optional<Quarto> findById(Integer quartoId);

    List<Quarto> findAll();
}
