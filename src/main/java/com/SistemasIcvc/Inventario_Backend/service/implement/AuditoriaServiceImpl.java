package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.AuditoriaDTO;
import com.SistemasIcvc.Inventario_Backend.mapper.AuditoriaMapper;
import com.SistemasIcvc.Inventario_Backend.repository.AuditoriaRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.AuditoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditoriaServiceImpl implements AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;
    private final AuditoriaMapper auditoriaMapper;

    @Override
    public AuditoriaDTO registrar(AuditoriaDTO dto) {
        return auditoriaMapper.toDto(auditoriaRepository.save(auditoriaMapper.toEntity(dto)));
    }

    @Override
    public AuditoriaDTO consultarPorId(Long id) {
        return auditoriaRepository.findById(id.intValue())
                .map(auditoriaMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Auditoría no encontrada con id: " + id));
    }

    @Override
    public List<AuditoriaDTO> listar() {
        return auditoriaRepository.findAll().stream()
                .map(auditoriaMapper::toDto)
                .collect(Collectors.toList());
    }
}
