package com.SistemasIcvc.Inventario_Backend.service.AutomaticeService;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoMovilDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoTelefonoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.*;
import com.SistemasIcvc.Inventario_Backend.mapper.*;
import com.SistemasIcvc.Inventario_Backend.repository.*;
import com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice.ActualizacionAutomatizadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualizacionAutomatizadaServiceImpl implements ActualizacionAutomatizadaService {

    private final EquipoRepository equipoRepository;
    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;
    private final ImpresoraRepository impresoraRepository;
    private final TelefonoRepository telefonoRepository;
    private final CamaraRepository camaraRepository;
    private final MovilRepository movilRepository;

    private final EquipoMapper equipoMapper;
    private final ComponenteMapper componenteMapper;
    private final ComputadoraMapper computadoraMapper;
    private final ImpresoraMapper impresoraMapper;
    private final TelefonoMapper telefonoMapper;
    private final CamaraMapper camaraMapper;
    private final MovilMapper movilMapper;

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

    @Override
    public void actualizarCamaraConEquipo(Long idEquipo, RegistroAutomatizadoCamarasDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto.getEquipo());
        equipo.setId(idEquipo.intValue());
        equipoRepository.save(equipo);

        Camara camara = camaraMapper.toEntity(dto.getCamara());
        camara.setId(dto.getCamara().getId());
        camara.setEquipo(equipo);
        camaraRepository.save(camara);
    }

    @Override
    public void actualizarMovilConEquipo(Long idEquipo, RegistroAutomatizadoMovilDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto.getEquipo());
        equipo.setId(idEquipo.intValue());
        equipoRepository.save(equipo);

        Movil movil = movilMapper.toEntity(dto.getMovil());
        movil.setId(dto.getMovil().getId());
        movil.setEquipo(equipo);
        movilRepository.save(movil);
    }

    @Override
    public void actualizarImpresoraConEquipo(Long idEquipo, RegistroAutomatizadoImpresoraDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto.getEquipo());
        equipo.setId(idEquipo.intValue());
        equipoRepository.save(equipo);

        Impresora impresora = impresoraMapper.toEntity(dto.getImpresora());
        impresora.setId(dto.getImpresora().getId());
        impresora.setEquipo(equipo);
        impresoraRepository.save(impresora);
    }

    @Override
    public void actualizarTelefonoConEquipo(Long idEquipo, RegistroAutomatizadoTelefonoDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto.getEquipo());
        equipo.setId(idEquipo.intValue());
        equipoRepository.save(equipo);

        Telefono telefono = telefonoMapper.toEntity(dto.getTelefono());
        telefono.setId(dto.getTelefono().getId());
        telefono.setEquipo(equipo);
        telefonoRepository.save(telefono);
    }


}
