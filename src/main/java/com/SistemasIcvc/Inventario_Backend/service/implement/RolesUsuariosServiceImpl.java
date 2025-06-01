package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.RolUsuarioDTOsConsulta;
import com.SistemasIcvc.Inventario_Backend.dto.RolesUsuariosDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Rol;
import com.SistemasIcvc.Inventario_Backend.entity.RolesUsuarios;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import com.SistemasIcvc.Inventario_Backend.repository.RolRepository;
import com.SistemasIcvc.Inventario_Backend.repository.RolesUsuariosRepository;
import com.SistemasIcvc.Inventario_Backend.repository.UsuarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.RolesUsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesUsuariosServiceImpl implements RolesUsuariosService {

    private final RolRepository rolRepository;
    private final RolesUsuariosRepository rolesUsuariosRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public String asignarRolAUsuario(RolesUsuariosDTO rolesUsuariosDTO){
        // Buscar el usuario por su nombre de usuario
        Usuario usuario = usuarioRepository.findByNombreUsuario(rolesUsuariosDTO.getNombreUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar  si el usuario ya tiene un rol asignado
        List<RolesUsuarios> rolesAsigandos = rolesUsuariosRepository.findByUsuario(usuario);
        if(!rolesAsigandos.isEmpty()) {
            throw new RuntimeException("El usuario ya tiene un rol asignado");
        }

        // Buscar el rol por su nombre
        Rol rol = rolRepository.findByNombreRol(rolesUsuariosDTO.getNombreRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Crear la relación y asignar el rol al usuario
        RolesUsuarios rolesUsuarios = new RolesUsuarios();
        rolesUsuarios.setUsuario(usuario);
        rolesUsuarios.setRol(rol);

        // Guardar la relación
        rolesUsuariosRepository.save(rolesUsuarios);

        return "Rol asignado correctamente al usuario";
    }

}
