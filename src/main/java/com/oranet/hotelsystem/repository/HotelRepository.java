package com.oranet.hotelsystem.repository;

import com.oranet.hotelsystem.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    Optional<Hotel> findById(Integer hotelId);

    List<Hotel> findAll();
}
