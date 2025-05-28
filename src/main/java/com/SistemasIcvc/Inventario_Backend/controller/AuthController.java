package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.LoginDTO;
import com.SistemasIcvc.Inventario_Backend.service.implement.UsuarioServiceImpl;
import com.SistemasIcvc.Inventario_Backend.service.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioServiceImpl usuarioServices;


    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody LoginDTO loginDTO) {
        boolean loginValido = usuarioServices.validarLogin(loginDTO.getNombreUsuario(), loginDTO.getContrasena());

        if (loginValido) {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Login exitoso");
            return ResponseEntity.ok(respuesta);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Credenciales inválidas o usuario inactivo");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }

}
