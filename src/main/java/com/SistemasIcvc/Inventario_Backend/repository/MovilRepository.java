package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.entity.Movil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Integer> {
    Optional<Movil> findByEquipo(Equipo equipo);
}
