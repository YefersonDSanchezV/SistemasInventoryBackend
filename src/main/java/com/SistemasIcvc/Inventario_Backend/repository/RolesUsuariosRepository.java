package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.dto.RolUsuarioDTOsConsulta;
import com.SistemasIcvc.Inventario_Backend.entity.RolesUsuarios;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RolesUsuariosRepository extends JpaRepository<RolesUsuarios, Integer> {
    List<RolesUsuarios> findByRolId(Integer rolId);
    List<RolesUsuarios> findByUsuarioId(Integer usuarioId);
    List<RolesUsuarios> findByUsuario(Usuario usuario);
}
