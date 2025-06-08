package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import com.SistemasIcvc.Inventario_Backend.entity.Rol;
import com.SistemasIcvc.Inventario_Backend.entity.RolesUsuarios;
import com.SistemasIcvc.Inventario_Backend.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariosCompletosDTO {
    private Persona persona;
    private Usuario usuario;
    private Rol rol;
}
