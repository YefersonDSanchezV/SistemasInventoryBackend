package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.RolDTO;
import com.SistemasIcvc.Inventario_Backend.dto.RolesUsuariosDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.RolService;
import com.SistemasIcvc.Inventario_Backend.service.services.RolesUsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;
    private final RolesUsuariosService rolesUsuariosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolDTO crearRol(@RequestBody RolDTO rolDTO) {
        return rolService.crearRol(rolDTO);
    }

    @PostMapping("/asignar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> asiganrarRolAUsuario(@RequestBody RolesUsuariosDTO rolesUsuariosDTO) {
        try {
            String resultado = rolesUsuariosService.asignarRolAUsuario(rolesUsuariosDTO);
            return ResponseEntity.ok(resultado);
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<RolDTO> obtenerRoles() {
        return rolService.listarRoles();
    }

}
