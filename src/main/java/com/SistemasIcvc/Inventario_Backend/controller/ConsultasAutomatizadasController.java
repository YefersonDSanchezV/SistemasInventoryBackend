package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.*;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ConsultasAutomatizasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consultar")
@RequiredArgsConstructor
public class ConsultasAutomatizadasController {

    private final ConsultasAutomatizasService consultasAutomatizadasService;

    @GetMapping("/computadoras-completas")
    public ResponseEntity<List<RegistroAutomatizadoComputadoraDTO>> consultarComputadorasConComponentes() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarComputadorasConComponentes());
    }

    @GetMapping("/camaras-completas")
    public ResponseEntity<List<RegistroAutomatizadoCamarasDTO>> consultarCamarasConEquipos() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarCamarasConEquipos());
    }

    @GetMapping("/moviles-completos")
    public ResponseEntity<List<RegistroAutomatizadoMovilDTO>> consultarMovilesConEquipos() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarMovilesConEquipos());
    }

    @GetMapping("/impresoras-completas")
    public ResponseEntity<List<RegistroAutomatizadoImpresoraDTO>> consultarImpresorasConEquipos() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarImpresorasConEquipos());
    }

    @GetMapping("/telefonos-completos")
    public ResponseEntity<List<RegistroAutomatizadoTelefonoDTO>> consultarTelefonosConEquipos() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarTelefonosConEquipos());
    }
}
