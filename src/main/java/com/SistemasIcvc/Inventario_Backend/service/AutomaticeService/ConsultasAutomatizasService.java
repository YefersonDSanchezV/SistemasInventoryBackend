package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoMovilDTO;
import com.SistemasIcvc.Inventario_Backend.entity.*;
import com.SistemasIcvc.Inventario_Backend.mapper.*;
import com.SistemasIcvc.Inventario_Backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultasAutomatizasService {

    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;
    private final ImpresoraRepository impresoraRepository;
    private final CamaraRepository camaraRepository;
    private final MovilRepository movilRepository;

    private final ComputadoraMapper computadoraMapper;
    private final ComponenteMapper componenteMapper;
    private final ImpresoraMapper impresoraMapper;
    private final CamaraMapper camaraMapper;
    private final EquipoMapper equipoMapper;
    private final MovilMapper movilMapper;

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

    public List<RegistroAutomatizadoMovilDTO> listarMovilesConEquipos() {
        List<Movil> movil = movilRepository.findAll();

        return movil.stream().map(mov -> {
            RegistroAutomatizadoMovilDTO dto = new RegistroAutomatizadoMovilDTO();
            dto.setMovil(movilMapper.toDto(mov));
            dto.setEquipo(equipoMapper.toDto(mov.getEquipo()));
            return dto;
        }).collect(Collectors.toList());
    }

    public List<RegistroAutomatizadoImpresoraDTO> listarImpresorasConEquipos(){
        List<Impresora> impresoras = impresoraRepository.findAll();

        return impresoras.stream().map(imp -> {
            RegistroAutomatizadoImpresoraDTO dto = new RegistroAutomatizadoImpresoraDTO();
            dto.setImpresora(impresoraMapper.toDto(imp));
            dto.setEquipo(equipoMapper.toDto(imp.getEquipo()));
            return dto;
        }).collect(Collectors.toList());
    }
}
