package com.SistemasIcvc.Inventario_Backend.service.services;

public interface ReporteService {
    String generarHojaDeVidaEquipo(Long equipoId);
    String generarHojaDeVidaUsuario(String identificacion);
    String generarReporteGeneralEquipos();
    String generarReporteGeneralUsuarios();
    String generarReporteAsignacionEquipo(Long equipoId);
}
