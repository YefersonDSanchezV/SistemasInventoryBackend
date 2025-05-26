package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import com.SistemasIcvc.Inventario_Backend.mapper.ComponenteMapper;
import com.SistemasIcvc.Inventario_Backend.repository.ComponenteRepository;
import com.SistemasIcvc.Inventario_Backend.repository.ComputadoraRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.ComponenteService;
import com.SistemasIcvc.Inventario_Backend.service.services.EquipoComponenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComponenteServiceImpl implements ComponenteService {

    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;
    private final ComponenteMapper componenteMapper;
    private final EquipoComponenteService equipoComponenteService;

    @Override
    public ComponenteDTO registrar(ComponenteDTO dto) {
        Componente componente = componenteMapper.toEntity(dto);
        componente.setComputadora(
                computadoraRepository.findById(dto.getComputadoraId())
                        .orElseThrow(() -> new RuntimeException("Computadora no encontrada"))
        );

        Componente componenteGuardado = componenteRepository.save(componente);
        Integer equipoId = componente.getComputadora().getEquipo().getId();
        equipoComponenteService.vincularComponenteAEquipo(equipoId, componenteGuardado.getId());
        return componenteMapper.toDto(componenteGuardado);
    }

    @Override
    public ComponenteDTO editar(Long id, ComponenteDTO dto) {
        Componente componente = componenteMapper.toEntity(dto);
        componente.setId(id.intValue());
        componente.setComputadora(
                computadoraRepository.findById(dto.getComputadoraId())
                        .orElseThrow(() -> new RuntimeException("Computadora no encontrada"))
        );
        return componenteMapper.toDto(componenteRepository.save(componente));
    }

    @Override
    public ComponenteDTO consultarPorId(Long id) {
        return componenteRepository.findById(id.intValue())
                .map(componenteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Componente no encontrado con ID: " + id));
    }

    @Override
    public List<ComponenteDTO> listarTodos() {
        return componenteRepository.findAll().stream()
                .map(componenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComponenteDTO> listarPorTipo(String tipo) {
        return componenteRepository.findAll().stream()
                .filter(c -> c.getTipo().equalsIgnoreCase(tipo))
                .map(componenteMapper::toDto)
                .collect(Collectors.toList());
    }
}

