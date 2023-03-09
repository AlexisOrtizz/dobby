package com.sistema.dobby.common.security;

import com.sistema.dobby.administration.model.Permiso;
import com.sistema.dobby.administration.model.Rol;
import com.sistema.dobby.administration.model.Usuario;
import com.sistema.dobby.administracion.repository.PermisoRepository;
import com.sistema.dobby.administracion.repository.RolRepository;
import com.sistema.dobby.administracion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup) return;

        Permiso readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE", "Permiso para solo lectura dentro del sistema.");
        Permiso writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE", "Permiso para agregar datos dentro del sistema.");

        List<Permiso> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        Rol adminRol = createRolIfNotFound("ROLE_ADMIN", "Rol que posee todos los permisos dentro del sistema", adminPrivileges);
        Rol userRol = createRolIfNotFound("ROLE_USER", "Usuario que puede recorrer el sistema sin hacer alguna operacion", Arrays.asList(readPrivilege));

        String username = "admin";

        if(usuarioRepository.findByUsername(username) == null) {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setEmail("admin@gmail.com");
            usuario.setPassword(passwordEncoder.encode("12345678"));
            usuario.setRoles(Arrays.asList(adminRol));

            usuarioRepository.save(usuario);
        }

        alreadySetup = true;
    }

    @Transactional
    Permiso createPrivilegeIfNotFound(String name, String description) {
        Permiso permiso = permisoRepository.findByNombre(name);

        if(permiso == null) {
            permiso = new Permiso(name, description);
            permisoRepository.save(permiso);
        }

        return permiso;
    }

    @Transactional
    Rol createRolIfNotFound(String name, String description, Collection<Permiso> permisos) {
        Rol rol = rolRepository.findByNombre(name);

        if(rol == null) {
            rol = new Rol(name, description);
            rol.setPermisos(permisos);
            rolRepository.save(rol);
        }

        return rol;
    }
}
