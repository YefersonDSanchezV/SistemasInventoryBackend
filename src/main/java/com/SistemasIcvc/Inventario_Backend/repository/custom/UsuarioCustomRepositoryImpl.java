package com.SistemasIcvc.Inventario_Backend.repository.custom;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.UsuariosCompletosDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import com.SistemasIcvc.Inventario_Backend.entity.Rol;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuarioCustomRepositoryImpl implements UsuarioCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuariosCompletosDTO> consultarUsuarioCompleto() {
        String jpql = "SELECT u FROM Usuario u JOIN FETCH u.persona p JOIN FETCH u.rolesUsuarios ru JOIN FETCH ru.rol r";

        List<Usuario> usuarios = entityManager.createQuery(jpql, Usuario.class).getResultList();

        List<UsuariosCompletosDTO> resultado = new ArrayList<>();

        for (Usuario u : usuarios) {
            Persona p = u.getPersona();
            Rol rol = u.getRolesUsuarios().iterator().next().getRol(); // si tiene varios, toma el primero
            resultado.add(new UsuariosCompletosDTO(p, u, rol));
        }

        return resultado;
    }
}
