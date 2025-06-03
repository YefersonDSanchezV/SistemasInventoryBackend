package com.SistemasIcvc.Inventario_Backend.controller;


import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.*;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ActualizacionAutomatizadaService;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.RegistroAutomatizadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro")
@RequiredArgsConstructor
public class RegistroAutomatizadoController {

    private final ActualizacionAutomatizadaService actualizacionAutomatizadaService;
    private final RegistroAutomatizadoService registroAutomatizadoService;

    @PostMapping("/computadora-completa")
    public ResponseEntity<Void> registrarComputadoraConComponentes(@RequestBody RegistroAutomatizadoComputadoraDTO request) {
        registroAutomatizadoService.registrarComputadoraConComponentes(request.getEquipo(), request.getComputadora(), request.getComponentes());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/computadoras-completas")
    public ResponseEntity<List<RegistroAutomatizadoComputadoraDTO>> consultarComputadorasConComponentes() {
        return ResponseEntity.ok(registroAutomatizadoService.listarComputadorasConComponentes());
    }


    @PostMapping("/equipo-telefono")
    public ResponseEntity<Void> registrarEquipoTelefono(@RequestBody RegistroAutomatizadoTelefonoDTO request) {
        registroAutomatizadoService.registrarEquipoConTelefono(request.getEquipo(), request.getTelefono());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/equipo-impresora")
    public ResponseEntity<Void> registrarEquipoImpresora(@RequestBody RegistroAutomatizadoImpresoraDTO request) {
        registroAutomatizadoService.registrarEquipoConImpresora(request.getEquipo(), request.getImpresora());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/equipo-movil")
    public ResponseEntity<Void> registrarEquipoMovil(@RequestBody RegistroAutomatizadoMovilDTO request) {
        registroAutomatizadoService.registrarEquipoConMovil(request.getEquipo(), request.getMovil());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/equipo-camara")
    public ResponseEntity<Void> registrarEquipoCamara(@RequestBody RegistroAutomatizadoCamarasDTO request) {
        registroAutomatizadoService.registrarCamaraConEquipo(request.getCamara(), request.getEquipo());
        return ResponseEntity.ok().build();
    }
}

