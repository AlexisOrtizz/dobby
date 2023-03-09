package com.sistema.dobby.administracion.controller;

import com.sistema.dobby.administracion.services.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // endpoints
    private final static String HOME_URL = "/";
    private final static String LOGIN_URL = "/login";

    // views
    private final static String HOME_VIEW = "/index";
    private final static String LOGIN_VIEW = "/login";


    @Autowired
    private UsuarioServiceImp usuarioService;


    @GetMapping(HOME_URL)
    public String home() {
        // retorna el nombre de la vista
        return HOME_VIEW;
    }

    @GetMapping(LOGIN_URL)
    public String login() {
        // retorna el nombre de la vista
        return LOGIN_VIEW;
    }
}
