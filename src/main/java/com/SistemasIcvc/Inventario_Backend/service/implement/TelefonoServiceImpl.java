package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.TelefonoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Telefono;
import com.SistemasIcvc.Inventario_Backend.mapper.TelefonoMapper;
import com.SistemasIcvc.Inventario_Backend.repository.TelefonoRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.TelefonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TelefonoServiceImpl implements TelefonoService {
    private final TelefonoRepository telefonoRepository;
    private final TelefonoMapper telefonoMapper;

    @Override
    public TelefonoDTO registrar(TelefonoDTO dto) {
        return telefonoMapper.toDto(telefonoRepository.save(telefonoMapper.toEntity(dto)));
    }

    @Override
    public TelefonoDTO editar(Long id, TelefonoDTO dto) {
        Telefono telefono = telefonoMapper.toEntity(dto);
        telefono.setId(id.intValue());
        return telefonoMapper.toDto(telefonoRepository.save(telefono));
    }

    @Override
    public TelefonoDTO consultarPorId(Long id) {
        return telefonoRepository.findById(id.intValue())
                .map(telefonoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con id: " + id));
    }

    @Override
    public List<TelefonoDTO> listar() {
        return telefonoRepository.findAll().stream()
                .map(telefonoMapper::toDto)
                .collect(Collectors.toList());
    }
}
