package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.entity.EquipoComponente;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoComponenteRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.EquipoComponenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipoComponenteServiceImpl implements EquipoComponenteService {

    private final EquipoComponenteRepository equipoComponenteRepository;

    @Override
    public EquipoComponenteDTO vincularComponenteAEquipo(Integer equipoId, Integer componenteId) {
        EquipoComponente equipoComponente = new EquipoComponente();
        equipoComponente.setEquipoId(equipoId);
        equipoComponente.setComponenteId(componenteId);
        return new EquipoComponenteDTO(equipoComponente.getId(), equipoId, componenteId);
    }
}
