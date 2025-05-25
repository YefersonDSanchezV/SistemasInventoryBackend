package com.SistemasIcvc.Inventario_Backend.repository;


import com.SistemasIcvc.Inventario_Backend.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {
}
