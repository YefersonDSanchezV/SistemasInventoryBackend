package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.*;
import com.SistemasIcvc.Inventario_Backend.entity.*;
import com.SistemasIcvc.Inventario_Backend.mapper.*;
import com.SistemasIcvc.Inventario_Backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultasAutomatizasService {

    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;
    private final ImpresoraRepository impresoraRepository;
    private final TelefonoRepository telefonoRepository;
    private final CamaraRepository camaraRepository;
    private final MovilRepository movilRepository;

    private final ComputadoraMapper computadoraMapper;
    private final ComponenteMapper componenteMapper;
    private final ImpresoraMapper impresoraMapper;
    private final TelefonoMapper telefonoMapper;
    private final CamaraMapper camaraMapper;
    private final EquipoMapper equipoMapper;
    private final MovilMapper movilMapper;
    private final EquipoRepository equipoRepository;

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

    public List<RegistroAutomatizadoTelefonoDTO> listarTelefonosConEquipos() {
        List<Telefono> telefonos = telefonoRepository.findAll();
        return telefonos.stream().map(tel -> {
            RegistroAutomatizadoTelefonoDTO dto = new RegistroAutomatizadoTelefonoDTO();
            dto.setTelefono(telefonoMapper.toDto(tel));
            dto.setEquipo(equipoMapper.toDto(tel.getEquipo()));
            return dto;
        }).collect(Collectors.toList());
    }

    public List<EquipoCompletoDTO> obtenerTodosLosEquipos(){
        List<Equipo> equipos = equipoRepository.findAll();
        List<EquipoCompletoDTO> resultado = new ArrayList<>();

        for ( Equipo equipo : equipos){
            EquipoCompletoDTO dto = new EquipoCompletoDTO();
            dto.setEquipo(equipo);

            dto.setComputadora(computadoraRepository.findByEquipo(equipo).orElse(null));
            dto.setCamara(camaraRepository.findByEquipo(equipo).orElse(null));
            dto.setImpresora(impresoraRepository.findByEquipo(equipo).orElse(null));
            dto.setMovil(movilRepository.findByEquipo(equipo).orElse(null));
            dto.setTelefono(telefonoRepository.findByEquipo(equipo).orElse(null));

            if(dto.getComputadora() != null){
                dto.setComponentes(componenteRepository.findByComputadora(dto.getComputadora()));
            }
            resultado.add(dto);
        }
        return resultado;
    }
}
