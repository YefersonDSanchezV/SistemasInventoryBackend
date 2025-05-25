package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.UsuarioDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.UsuarioServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioRegistrado = usuarioServices.registrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable String identificacion,
                                                    @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioEditado = usuarioServices.editarUsuario(identificacion, usuarioDTO);
        return ResponseEntity.ok(usuarioEditado);
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<UsuarioDTO> consultarPorIdentificacion(@PathVariable String identificacion) {
        UsuarioDTO usuario = usuarioServices.consultarPorIdentificacion(identificacion);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<UsuarioDTO>> consultarPorEstado(@PathVariable String estado) {
        List<UsuarioDTO> usuarios = usuarioServices.consultarPorEstado(estado);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioServices.listarTodos();
        return ResponseEntity.ok(usuarios);
    }
}
