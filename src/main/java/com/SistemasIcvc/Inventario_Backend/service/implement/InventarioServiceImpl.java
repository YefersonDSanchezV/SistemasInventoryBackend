package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.InventarioDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Inventario;
import com.SistemasIcvc.Inventario_Backend.mapper.InventarioMapper;
import com.SistemasIcvc.Inventario_Backend.repository.InventarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final InventarioMapper inventarioMapper;

    @Override
    public InventarioDTO registrar(InventarioDTO dto) {
        return inventarioMapper.toDto(inventarioRepository.save(inventarioMapper.toEntity(dto)));
    }

    @Override
    public InventarioDTO editar(Long id, InventarioDTO dto) {
        Inventario inventario = inventarioMapper.toEntity(dto);
        inventario.setId(id.intValue());
        return inventarioMapper.toDto(inventarioRepository.save(inventario));
    }

    @Override
    public InventarioDTO consultarPorId(Long id) {
        return inventarioRepository.findById(id.intValue())
                .map(inventarioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
    }

    @Override
    public List<InventarioDTO> listar() {
        return inventarioRepository.findAll().stream()
                .map(inventarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
