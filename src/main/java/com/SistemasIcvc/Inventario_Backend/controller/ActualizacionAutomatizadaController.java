package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoMovilDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoTelefonoDTO;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ActualizacionAutomatizadaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actualizar")
@RequiredArgsConstructor
public class ActualizacionAutomatizadaController {

    private final ActualizacionAutomatizadaServiceImpl actualizacionAutomatizadaService;

    @PutMapping("/computadora-completa/{idEquipo}")
    public ResponseEntity<Void> actualizarComputadoraCompleta(
            @PathVariable Long idEquipo,
            @RequestBody ActualizacionAutomaticaComputadoraDTO dto) {
        actualizacionAutomatizadaService.actualizarComputadoraConComponentes(idEquipo, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/camara-completa/{idEquipo}")
    public ResponseEntity<Void> actualizarCamaraCompleta(
            @PathVariable Long idEquipo,
            @RequestBody RegistroAutomatizadoCamarasDTO dto) {
        actualizacionAutomatizadaService.actualizarCamaraConEquipo(idEquipo, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movil-completo/{idEquipo}")
    public ResponseEntity<Void> actualizarMovilCompleto(
            @PathVariable Long idEquipo,
            @RequestBody RegistroAutomatizadoMovilDTO dto) {
        actualizacionAutomatizadaService.actualizarMovilConEquipo(idEquipo, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/impresora-completa/{idEquipo}")
    public ResponseEntity<Void> actualizarImpresoraCompleta(
            @PathVariable Long idEquipo,
            @RequestBody RegistroAutomatizadoImpresoraDTO dto) {
        actualizacionAutomatizadaService.actualizarImpresoraConEquipo(idEquipo, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/telefono-completo/{idEquipo}")
    public ResponseEntity<Void> actualizarTelefonoCompleto(
            @PathVariable Long idEquipo,
            @RequestBody RegistroAutomatizadoTelefonoDTO dto) {
        actualizacionAutomatizadaService.actualizarTelefonoConEquipo(idEquipo, dto);
        return ResponseEntity.ok().build();
    }
}
