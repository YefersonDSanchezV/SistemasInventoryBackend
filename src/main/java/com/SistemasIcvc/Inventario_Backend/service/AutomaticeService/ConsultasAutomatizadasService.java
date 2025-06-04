package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Camara;
import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import com.SistemasIcvc.Inventario_Backend.mapper.CamaraMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.ComponenteMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.ComputadoraMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.EquipoMapper;
import com.SistemasIcvc.Inventario_Backend.repository.CamaraRepository;
import com.SistemasIcvc.Inventario_Backend.repository.ComponenteRepository;
import com.SistemasIcvc.Inventario_Backend.repository.ComputadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultasAutomatizadasService {

    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;
    private final CamaraRepository camaraRepository;

    private final ComputadoraMapper computadoraMapper;
    private final ComponenteMapper componenteMapper;
    private final CamaraMapper camaraMapper;
    private final EquipoMapper equipoMapper;

    public List<RegistroAutomatizadoComputadoraDTO> listarComputadorasConComponentes() {
        List<Computadora> computadoras = computadoraRepository.findAll();

        return computadoras.stream().map(comp -> {
            RegistroAutomatizadoComputadoraDTO dto = new RegistroAutomatizadoComputadoraDTO();
            dto.setComputadora(computadoraMapper.toDto(comp));
            dto.setEquipo(equipoMapper.toDto(comp.getEquipo()));
            List<Componente> componentes = componenteRepository.findByComputadoraId(comp.getId());
            dto.setComponentes(componentes.stream().map(componenteMapper::toDto).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }

    public List<RegistroAutomatizadoCamarasDTO> listarCamarasConEquipos() {
        List<Camara> camaras = camaraRepository.findAll();

        return camaras.stream().map(cam -> {
            RegistroAutomatizadoCamarasDTO dto = new RegistroAutomatizadoCamarasDTO();
            dto.setCamara(camaraMapper.toDto(cam));
            dto.setEquipo(equipoMapper.toDto(cam.getEquipo()));
            return dto;
        }).collect(Collectors.toList());
    }
}
