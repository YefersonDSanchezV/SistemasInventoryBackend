package com.SistemasIcvc.Inventario_Backend.controller.AutomatizacionController;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ActualizacionAutomatizadaService;
import com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice.ActualizacionAutomatizadaCamara;
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

    @PutMapping("/camara-completa/{idEquipo}")
    public ResponseEntity<Void> actualizarCamaraCompleta(
            @PathVariable Long idEquipo,
            @RequestBody RegistroAutomatizadoCamarasDTO dto) {
        actualizacionAutomatizadaService.actualizarCamaraConEquipo(idEquipo, dto);
        return ResponseEntity.ok().build();
    }
}
