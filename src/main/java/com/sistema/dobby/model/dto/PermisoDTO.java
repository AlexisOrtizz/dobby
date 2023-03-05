package com.sistema.dobby.model.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PermisoDTO {
    private Long idPermiso;
    private String nombre;
    private String descripcion;
    private Long idVista;
}
