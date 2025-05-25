package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.mapper.ComputadoraMapper;
import com.SistemasIcvc.Inventario_Backend.repository.ComputadoraRepository;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.ComputadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputadoraServiceImpl implements ComputadoraService {

    private final EquipoRepository equipoRepository;
    private final ComputadoraRepository computadoraRepository;
    private final ComputadoraMapper computadoraMapper;

    @Override
    public ComputadoraDTO registrar(ComputadoraDTO dto) {

        if(dto.getTipoEquipo() != null){
            Equipo equipo = equipoRepository.findFirstByTipoEquipoIgnoreCase(dto.getTipoEquipo())
                    .orElseThrow(() -> new RuntimeException("Equipo no encontrado con nombre: " + dto.getTipoEquipo()));
            dto.setEquipoId(equipo.getId());
        }

        Computadora computadora = computadoraMapper.toEntity(dto);
        return computadoraMapper.toDto(computadoraRepository.save(computadora));
    }

    @Override
    public ComputadoraDTO editar(Long id, ComputadoraDTO dto) {
        Computadora computadora = computadoraMapper.toEntity(dto);
        computadora.setId(id.intValue());
        return computadoraMapper.toDto(computadoraRepository.save(computadora));
    }

    @Override
    public ComputadoraDTO consultarPorId(Long id) {
        return computadoraRepository.findById(id.intValue())
                .map(computadoraMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Computadora no encontrada con id: " + id));
    }

    @Override
    public List<ComputadoraDTO> listar() {
        return computadoraRepository.findAll().stream()
                .map(computadoraMapper::toDto)
                .collect(Collectors.toList());
    }
}
