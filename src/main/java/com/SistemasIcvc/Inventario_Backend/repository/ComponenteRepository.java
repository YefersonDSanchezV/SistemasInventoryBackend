package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer> {
    List<Componente> findByComputadoraId(Integer computadoraId);
}