package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.*;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import com.SistemasIcvc.Inventario_Backend.mapper.ComponenteMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.ComputadoraMapper;
import com.SistemasIcvc.Inventario_Backend.mapper.EquipoMapper;
import com.SistemasIcvc.Inventario_Backend.repository.ComponenteRepository;
import com.SistemasIcvc.Inventario_Backend.repository.ComputadoraRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistroAutomatizadoService {

    private final ComputadoraMapper computadoraMapper;
    private final EquipoMapper equipoMapper;
    private final ComponenteMapper componenteMapper;

    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;

    private final MovilService movilService;
    private final EquipoService equipoService;
    private final TelefonoService telefonoService;
    private final ComputadoraService computadoraService;
    private final ImpresoraService impresoraService;
    private final ComponenteService componenteService;
    private final CamaraService camaraService;

    @Transactional
    public void registrarComputadoraConComponentes(EquipoDTO equipoDTO, ComputadoraDTO computadoraDTO, List<ComponenteDTO> componentes) {
        EquipoDTO equipoRegistrado = equipoService.registrarEquipo(equipoDTO);
        computadoraDTO.setEquipoId(equipoRegistrado.getId());
        ComputadoraDTO computadoraRegistrada = computadoraService.registrar(computadoraDTO);

        Set<String> serialRegistrados = new HashSet<>();
        for (ComponenteDTO componente : componentes) {
            if (serialRegistrados.contains(componente.getSerial())){
                throw new RuntimeException("Ya existe un componente con el serial: " + componente.getSerial());
            }
            componente.setComputadoraId(computadoraRegistrada.getId());
            componenteService.registrar(componente);
            serialRegistrados.add(componente.getSerial());
        }
    }

    @Transactional
    public void registrarEquipoConTelefono(EquipoDTO equipoDTO, TelefonoDTO telefonoDTO) {
        if(telefonoService.listar().stream().anyMatch(t -> t.getExtension().equals(telefonoDTO.getExtension()))){
            throw new RuntimeException("Ya existe un teléfono con la extensión: " + telefonoDTO.getExtension());
        }
        EquipoDTO equipoRegistrado = equipoService.registrarEquipo(equipoDTO);
        telefonoDTO.setEquipoId(equipoRegistrado.getId());
        telefonoService.registrar(telefonoDTO);
    }

    @Transactional
    public void registrarEquipoConImpresora(EquipoDTO equipoDTO, ImpresoraDTO impresoraDTO) {
        EquipoDTO equipoRegistrado = equipoService.registrarEquipo(equipoDTO);
        impresoraDTO.setEquipoId(equipoRegistrado.getId());
        impresoraService.registrar(impresoraDTO);
    }

    @Transactional
    public void registrarEquipoConMovil(EquipoDTO equipoDTO, MovilDTO movilDTO) {
        EquipoDTO equipoRegistrado = equipoService.registrarEquipo(equipoDTO);
        movilDTO.setEquipoId(equipoRegistrado.getId());
        movilService.registrar(movilDTO);
    }

    @Transactional
    public void registrarCamaraConEquipo(CamaraDTO camaraDTO, EquipoDTO equipoDTO) {
        EquipoDTO equipoRegistrado = equipoService.registrarEquipo(equipoDTO);
        camaraDTO.setEquipoId(equipoRegistrado.getId());
        camaraService.registrar(camaraDTO);
    }

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

}
