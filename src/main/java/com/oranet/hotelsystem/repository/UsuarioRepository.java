package com.oranet.hotelsystem.repository;

import com.oranet.hotelsystem.model.Hotel;
import com.oranet.hotelsystem.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.contato.email = ?1")
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();
}
