package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administracion.repository.PermisoRepository;
import com.sistema.dobby.administration.model.dto.PermisoDTO;
import com.sistema.dobby.administration.model.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PermisoServiceImp implements PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;


    public void crearPermisos() {

        List<Permiso> permisos = new ArrayList<>();

        permisos.add(new Permiso("conectarse", "Permiso para conectase al sistema"));
        permisos.add(new Permiso("asignar-rol-usuario", "Permite asignar roles con permiso a un Usuario"));
        permisos.add(new Permiso("asignar-permisos-rol", "Permite asignar permisos a un rol"));
        permisos.add(new Permiso("eliminar-permisos-rol", "Permite eliminar permisos a un rol"));
        permisos.add(new Permiso("agregar-miembro-proyecto", "Permite agregar nuevos miembros al proyecto"));
        permisos.add(new Permiso("eliminar-miembro-proyecto", "Permite eliminar miembros del proyecto"));

        permisoRepository.saveAll(permisos);
    }

    @Override
    public void convertirDTO(Permiso permiso, PermisoDTO objetoDTO) {
        permiso.setNombre(objetoDTO.getNombre());
        permiso.setDescripcion(objetoDTO.getDescripcion());
        return;
    }

    @Override
    public Permiso guardar(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    @Override
    public List<Permiso> listar() {
        return permisoRepository.findAll();
    }

    @Override
    public Permiso existePermiso(Long id) {
        return permisoRepository.findByIdPermiso(id);
    }

    @Override
    public void eliminarPermiso(Permiso permiso) {
        permisoRepository.delete(permiso);
    }
}
