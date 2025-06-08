package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.entity.Impresora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpresoraRepository extends JpaRepository<Impresora, Integer> {
    Optional<Impresora> findByEquipo(Equipo equipo);
}