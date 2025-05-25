package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.mapper.RolMapper;
import com.SistemasIcvc.Inventario_Backend.dto.RolDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Rol;
import com.SistemasIcvc.Inventario_Backend.repository.RolRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolDTO crearRol(RolDTO rolDTO) {
        Rol rol = rolMapper.toEntity(rolDTO);
        return rolMapper.toDto(rolRepository.save(rol));
    }

    @Override
    public List<RolDTO> listarRoles() {
        return rolRepository.findAll().stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }
}
