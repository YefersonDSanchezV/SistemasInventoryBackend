package com.SistemasIcvc.Inventario_Backend.repository;


import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByNombre(String nombre);
    Optional<Persona> findByIdidentificacion(String ididentificacion);

}
