package com.SistemasIcvc.Inventario_Backend.controller.AutomatizacionController;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.service.AutomaticeService.ConsultasAutomatizadasService;
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

    private final ConsultasAutomatizadasService consultasAutomatizadasService;

    @GetMapping("/computadoras-completas")
    public ResponseEntity<List<RegistroAutomatizadoComputadoraDTO>> consultarComputadorasConComponentes() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarComputadorasConComponentes());
    }

    @GetMapping("/camaras-completas")
    public ResponseEntity<List<RegistroAutomatizadoCamarasDTO>> consultarCamarasConEquipos() {
        return ResponseEntity.ok(consultasAutomatizadasService.listarCamarasConEquipos());
    }
}
