package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Integer> {
    Optional<Computadora> findByEquipo(Equipo equipo);
}