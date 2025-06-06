package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.MovilDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.entity.Movil;
import com.SistemasIcvc.Inventario_Backend.mapper.MovilMapper;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoRepository;
import com.SistemasIcvc.Inventario_Backend.repository.MovilRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.MovilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovilServiceImpl implements MovilService {

    private final MovilRepository movilRepository;
    private final EquipoRepository equipoRepository;
    private final MovilMapper movilMapper;

    @Override
    public MovilDTO registrar(MovilDTO dto) {
        Movil movil = movilMapper.toEntity(dto);
        Equipo equipo = equipoRepository.findById(dto.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        movil.setEquipo(equipo);
        Movil guardada = movilRepository.save(movil);
        return movilMapper.toDto(guardada);
    }

    @Override
    public MovilDTO editar(Long id, MovilDTO dto) {
        Movil movil = movilMapper.toEntity(dto);
        movil.setId(id.intValue());
        return movilMapper.toDto(movilRepository.save(movil));
    }

    @Override
    public MovilDTO consultarPorId(Long id) {
        return movilRepository.findById(id.intValue())
                .map(movilMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Movil no encontrado con id: " + id));
    }

    @Override
    public List<MovilDTO> listar() {
        return movilRepository.findAll().stream()
                .map(movilMapper::toDto)
                .collect(Collectors.toList());
    }
}
