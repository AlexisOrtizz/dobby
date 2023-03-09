package com.sistema.dobby.administration.model.dto;

import lombok.Data;

@Data
public class PermisoDTO {
    private Long idPermiso;
    private String nombre;
    private String descripcion;
    private Long idVista;
}
