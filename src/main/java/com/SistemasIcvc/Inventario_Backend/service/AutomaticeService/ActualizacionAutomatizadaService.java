package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import com.SistemasIcvc.Inventario_Backend.mapper.ComponenteMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.ComputadoraMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.EquipoMapper;
import com.SistemasIcvc.Inventario_Backend.repository.ComponenteRepository;
import com.SistemasIcvc.Inventario_Backend.repository.ComputadoraRepository;
import com.SistemasIcvc.Inventario_Backend.repository.EquipoRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice.ActualizacionAutomatizadaComputadora;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualizacionAutomatizadaService implements ActualizacionAutomatizadaComputadora {

    private final EquipoRepository equipoRepository;
    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;

    private final EquipoMapper equipoMapper;
    private final ComponenteMapper componenteMapper;
    private final ComputadoraMapper computadoraMapper;

    @Override
    public void actualizarComputadoraConComponentes(Long idEquipo, ActualizacionAutomaticaComputadoraDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto.getEquipo());
        equipo.setId(idEquipo.intValue());
        equipoRepository.save(equipo);

        Computadora computadora = computadoraMapper.toEntity(dto.getComputadora());
        computadora.setId(dto.getComputadora().getId());
        computadora.setEquipo(equipo);
        computadoraRepository.save(computadora);

        List<Componente> componentes = dto.getComponentes().stream()
                .map(componenteMapper::toEntity)
                .peek(c -> {
                    c.setComputadora(computadora);
                    c.setId(c.getId());
                })
                .toList();
        componenteRepository.saveAll(componentes);
    }
}
