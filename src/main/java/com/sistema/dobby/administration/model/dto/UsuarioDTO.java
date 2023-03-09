package com.sistema.dobby.administration.model.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String email;
    private String password;
    private String user;
    private Integer idRol;
}
