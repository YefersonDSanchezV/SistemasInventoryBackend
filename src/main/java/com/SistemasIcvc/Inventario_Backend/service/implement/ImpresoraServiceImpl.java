package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.ImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Impresora;
import com.SistemasIcvc.Inventario_Backend.mapper.ImpresoraMapper;
import com.SistemasIcvc.Inventario_Backend.repository.ImpresoraRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.ImpresoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImpresoraServiceImpl implements ImpresoraService {

    private final ImpresoraRepository impresoraRepository;
    private final ImpresoraMapper impresoraMapper;

    @Override
    public ImpresoraDTO registrar(ImpresoraDTO dto) {
        return impresoraMapper.toDto(impresoraRepository.save(impresoraMapper.toEntity(dto)));
    }

    @Override
    public ImpresoraDTO editar(Long id, ImpresoraDTO dto) {
        Impresora impresora = impresoraMapper.toEntity(dto);
        impresora.setId(id.intValue());
        return impresoraMapper.toDto(impresoraRepository.save(impresora));
    }

    @Override
    public ImpresoraDTO consultarPorId(Long id) {
        return impresoraRepository.findById(id.intValue())
                .map(impresoraMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Impresora no encontrada con id: " + id));
    }

    @Override
    public List<ImpresoraDTO> listar() {
        return impresoraRepository.findAll().stream()
                .map(impresoraMapper::toDto)
                .collect(Collectors.toList());
    }
}
