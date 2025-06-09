package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Optional<Equipo> findFirstByEstadoIgnoreCase(String estado);
    Optional<Equipo> findFirstByNombreMaquinaIgnoreCase(String nombreMaquina);
    Optional<Equipo> findByNombreMaquina(String nombreMaquina);
}
