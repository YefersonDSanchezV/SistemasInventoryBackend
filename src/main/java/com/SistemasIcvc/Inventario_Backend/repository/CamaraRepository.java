package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Camara;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CamaraRepository extends JpaRepository<Camara, Integer> {
    Optional<Camara> findByEquipo(Equipo equipo);
}
