package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.CamaraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Camara;
import com.SistemasIcvc.Inventario_Backend.mapper.CamaraMapper;
import com.SistemasIcvc.Inventario_Backend.repository.CamaraRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.CamaraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamaraServiceImpl implements CamaraService {

    private final CamaraRepository camaraRepository;
    private final CamaraMapper camaraMapper;

    @Override
    public CamaraDTO registrar(CamaraDTO dto) {
        return camaraMapper.toDto(camaraRepository.save(camaraMapper.toEntity(dto)));
    }

    @Override
    public CamaraDTO editar(Long id, CamaraDTO dto) {
        Camara camara = camaraMapper.toEntity(dto);
        camara.setId(id.intValue());
        return camaraMapper.toDto(camaraRepository.save(camara));
    }

    @Override
    public CamaraDTO consultarPorId(Long id) {
        return camaraRepository.findById(id.intValue())
                .map(camaraMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + id));
    }

    @Override
    public List<CamaraDTO> listar() {
        return camaraRepository.findAll().stream()
                .map(camaraMapper::toDto)
                .collect(Collectors.toList());
    }
}
