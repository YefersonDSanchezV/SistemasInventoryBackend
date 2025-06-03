package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ActualizacionAutomatizadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actualizar")
@RequiredArgsConstructor
public class ActualizacionAutomatizadaController {

    private final ActualizacionAutomatizadaService actualizacionAutomatizadaService;

    @PutMapping("/computadora-completa/{idEquipo}")
    public ResponseEntity<Void> actualizarComputadoraCompleta(
            @PathVariable Long idEquipo,
            @RequestBody ActualizacionAutomaticaComputadoraDTO dto) {
        actualizacionAutomatizadaService.actualizarComputadoraConComponentes(idEquipo, dto);
        return ResponseEntity.ok().build();
    }
}
