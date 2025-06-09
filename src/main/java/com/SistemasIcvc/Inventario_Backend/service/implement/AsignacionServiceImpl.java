package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.AsignacionDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Asignacion;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import com.SistemasIcvc.Inventario_Backend.mapper.AsignacionMapper;
import com.SistemasIcvc.Inventario_Backend.repository.AsignacionRepository;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoRepository;
import com.SistemasIcvc.Inventario_Backend.repository.UsuarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignacionServiceImpl implements AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final EquipoRepository equipoRepository;
    private final AsignacionMapper asignacionMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public AsignacionDTO registrarAsignacion(AsignacionDTO dto) {
        Equipo equipo = equipoRepository.findByNombreMaquina(dto.getNombreEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario asignador no encontrado"));

        Asignacion asignacion = new Asignacion();
        asignacion.setEquipo(equipo);
        asignacion.setNombrePersona(dto.getNombrePersona());
        asignacion.setFechaAsignacion(LocalDateTime.now());
        asignacion.setUsuario(usuario); // asigna el usuario que realiza la acción

        asignacionRepository.save(asignacion);
        return asignacionMapper.toDto(asignacion);
    }




    @Override
    public List<AsignacionDTO> consultarAsignaciones() {
        return asignacionRepository.findAll()
                .stream()
                .map(asignacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AsignacionDTO consultarPorNombrePersona(String nombrePersona) {
        return asignacionRepository.findAll()
                .stream()
                .filter(a -> a.getNombrePersona().equalsIgnoreCase(nombrePersona))
                .findFirst()
                .map(asignacionMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
    }

    @Override
    public AsignacionDTO editarAsignacion(String nombrePersona, AsignacionDTO dto) {
        Asignacion asignacionExistente = asignacionRepository.findAll()
                .stream()
                .filter(a -> a.getNombrePersona().equalsIgnoreCase(nombrePersona))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));

        asignacionExistente.setNombrePersona(dto.getNombrePersona());

        // Obtener entidad Equipo desde su ID
        Equipo equipo = equipoRepository.findByNombreMaquina(dto.getNombreEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        asignacionExistente.setEquipo(equipo);

        asignacionExistente.setFechaAsignacion(LocalDateTime.now());

        return asignacionMapper.toDto(asignacionRepository.save(asignacionExistente));
    }

    @Override
    public List<AsignacionDTO> obtenerAsignacionCompleta() {
        List<Asignacion> asignaciones = asignacionRepository.findAll();
        List<AsignacionDTO> resultado = new ArrayList<>();

        for (Asignacion asignacion : asignaciones) {
            AsignacionDTO dto = new AsignacionDTO();
            dto.setNombrePersona(asignacion.getNombrePersona());
            dto.setNombreUsuario(asignacion.getUsuario().getNombreUsuario());
            dto.setNombreEquipo(asignacion.getEquipo().getNombreMaquina());
            dto.setEquipoDetalle(asignacion.getEquipo()); // trae todos los datos del equipo

            resultado.add(dto);
        }

        return resultado;
    }


}
