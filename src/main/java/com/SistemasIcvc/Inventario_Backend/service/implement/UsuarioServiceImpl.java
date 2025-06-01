package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import com.SistemasIcvc.Inventario_Backend.entity.RolesUsuarios;
import com.SistemasIcvc.Inventario_Backend.mapper.UsuarioMapper;
import com.SistemasIcvc.Inventario_Backend.dto.UsuarioDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import com.SistemasIcvc.Inventario_Backend.repository.PersonaRepository;
import com.SistemasIcvc.Inventario_Backend.repository.UsuarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.UsuarioServices;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioServices {

    private final PersonaRepository personaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Persona persona = personaRepository.findByIdidentificacion(usuarioDTO.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con identificacion: " + usuarioDTO.getPersonaId()));

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setPersona(persona); // Vincula la persona por ididentificacion
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO editarUsuario(String identificacion, UsuarioDTO usuarioDTO) {

        Usuario usuarioExistente = usuarioRepository.findById(Integer.valueOf(identificacion)) // Suponiendo que identificacion es un número
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con identificacion: " + identificacion));

        Persona persona = personaRepository.findByIdidentificacion(usuarioDTO.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con identificacion: " + usuarioDTO.getPersonaId()));

        Usuario usuarioActualizado = usuarioMapper.toEntity(usuarioDTO);
        usuarioActualizado.setId(usuarioExistente.getId());
        usuarioActualizado.setPersona(persona);

        return usuarioMapper.toDto(usuarioRepository.save(usuarioActualizado));






        /*Optional<Usuario> optionalUsuario = usuarioRepository.findById(Integer.valueOf(identificacion)); // Suponiendo que identificacion es un número
        if (optionalUsuario.isPresent()) {
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            usuario.setId(optionalUsuario.get().getId());
            return usuarioMapper.toDto(usuarioRepository.save(usuario));
        }
        throw new RuntimeException("Usuario no encontrado con identificacion: " + identificacion);*/
    }


    @Override
    public UsuarioDTO consultarPorIdentificacion(String identificacion) {
        return usuarioRepository.findById(Integer.valueOf(identificacion)) // Suponiendo que la identificación es un número
                .map(usuarioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con identificacion: " + identificacion));
    }

    @Override
    public UsuarioDTO consultarPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario)
                .map(usuarioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre: " + nombreUsuario));
    }


    @Override
    public List<UsuarioDTO> consultarPorEstado(String estado) {
        Boolean estadoBool = Boolean.valueOf(estado);
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getEstado().equals(estadoBool))
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                //.filter(u -> u.getPersona() != null)
                .map(this::mapUsuarioConRoles)
                .collect(Collectors.toList());
    }

    private UsuarioDTO mapUsuarioConRoles(Usuario usuario) {
        UsuarioDTO dto = usuarioMapper.toDto(usuario);

        Hibernate.initialize(usuario.getRolesUsuarios());

        //Set<RolesUsuarios> rolesUsuarios = new HashSet<>(usuario.getRolesUsuarios());
        List<String> roles = usuario.getRolesUsuarios().stream()
                .map(ru -> ru.getRol().getNombreRol())
                .toList();
        dto.setRoles(roles);
        return dto;
    }

    public boolean validarLogin(String nombreUsuario, String contrasena) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getContrasena().equals(contrasena) && usuario.getEstado();
        }
        return false;
    }
}
