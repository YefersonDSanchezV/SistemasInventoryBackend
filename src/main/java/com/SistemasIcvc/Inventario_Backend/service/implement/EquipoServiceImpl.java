package com.SistemasIcvc.Inventario_Backend.service.implement;


import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import com.SistemasIcvc.Inventario_Backend.mapper.EquipoMapper;
import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoRepository;
import com.SistemasIcvc.Inventario_Backend.repository.UsuarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final UsuarioRepository usuarioRepository;
    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    @Override
    public EquipoDTO registrarEquipo(EquipoDTO equipoDTO) {
        if (equipoDTO.getNombreUsuario() != null){
            Usuario usuario = usuarioRepository.findByNombreUsuario(equipoDTO.getNombreUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre: " + equipoDTO.getNombreUsuario()));
            equipoDTO.setUsuarioRegistra(usuario.getId());
        }

        Equipo equipo = equipoMapper.toEntity(equipoDTO);
        return equipoMapper.toDto(equipoRepository.save(equipo));
    }

    @Override
    public EquipoDTO editarEquipoPorId(Long id, EquipoDTO equipoDTO) {
        Equipo equipo = equipoMapper.toEntity(equipoDTO);
        equipo.setId(id.intValue());
        return equipoMapper.toDto(equipoRepository.save(equipo));
    }

    @Override
    public EquipoDTO editarEquipoPorEstado(String estado, EquipoDTO equipoDTO) {
        Optional<Equipo> equipoExistente = equipoRepository.findFirstByEstadoIgnoreCase(estado);

        if (equipoExistente.isPresent()) {
            Equipo equipo = equipoMapper.toEntity(equipoDTO);
            equipo.setId(equipoExistente.get().getId());
            return equipoMapper.toDto(equipoRepository.save(equipo));
        }

        throw new RuntimeException("No se encontró equipo con estado: " + estado);
    }

    @Override
    public EquipoDTO editarEquipoPorNombre(String nombre, EquipoDTO equipoDTO) {
        Optional<Equipo> equipoExistente = equipoRepository.findFirstByNombreMaquinaIgnoreCase(nombre);

        if (equipoExistente.isPresent()) {
            Equipo equipo = equipoMapper.toEntity(equipoDTO);
            equipo.setId(equipoExistente.get().getId());
            return equipoMapper.toDto(equipoRepository.save(equipo));
        }

        throw new RuntimeException("No se encontró equipo con nombre: " + nombre);
    }

    @Override
    public EquipoDTO consultarPorId(Long id) {
        return equipoRepository.findById(id.intValue())
                .map(equipoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: " + id));
    }

    @Override
    public List<EquipoDTO> consultarPorFechaRegistro(String fecha) {
        return equipoRepository.findAll().stream()
                .filter(e -> e.getFechaRegistro().toString().contains(fecha))
                .map(equipoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EquipoDTO> consultarPorEstado(String estado) {
        return equipoRepository.findAll().stream()
                .filter(e -> e.getEstado().equalsIgnoreCase(estado))
                .map(equipoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EquipoDTO> listarTodos() {
        return equipoRepository.findAll().stream()
                .map(equipoMapper::toDto)
                .collect(Collectors.toList());
    }
}
