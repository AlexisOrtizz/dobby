package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administracion.repository.RolRepository;
import com.sistema.dobby.administration.model.dto.RolDTO;
import com.sistema.dobby.administration.model.Permiso;
import com.sistema.dobby.administration.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImp implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoServiceImp permisoService;

    public Rol crearAdmin() {
        permisoService.crearPermisos();

        Rol admin = new Rol("admin", "Super usuario del sistema");
        Rol conectarse = new Rol("conectarse", "Permiso solo conectarse al sistema");
        Rol creador = new Rol("creador", "Permite hacer CRUD en las distintas vistas");

        /* asignacion de todos los permisos al admin */
        for(Permiso permiso : permisoService.listar()) {
            admin.getPermisos().add(permiso);
            if(permiso.getNombre().equals("conectarse")) {
                conectarse.getPermisos().add(permiso);
                creador.getPermisos().add(permiso);
            }
            if(permiso.getNombre().contains("crear")) {
                creador.getPermisos().add(permiso);
            }
        }

        rolRepository.save(new Rol("Sin permisos", "Rol sin permisos"));
        rolRepository.save(conectarse);
        rolRepository.save(creador);
        return rolRepository.save(admin);

    }

    @Override
    public Rol existeRol(Long id) {
        return rolRepository.findByIdRol(id);
    }

    @Override
    public void convertirDTO(Rol rol, RolDTO objetoDTO) {
        rol.setNombre(objetoDTO.getNombre());
        rol.setDescripcion(objetoDTO.getDescripcion());
        return;
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void eliminarRol(Rol rol) {
        rolRepository.delete(rol);
    }

}
