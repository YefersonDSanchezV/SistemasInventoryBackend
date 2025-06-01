package com.SistemasIcvc.Inventario_Backend.repository;

import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @EntityGraph(attributePaths = {"rolesUsuarios.rol", "persona"})
    Optional<Usuario> findById(Integer id);

    @EntityGraph(attributePaths = {"persona"})
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}
