package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administration.model.Permiso;
import com.sistema.dobby.administration.model.dto.PermisoDTO;

import java.util.List;

public interface PermisoService {

    /**
     * Este método mapea los datos de un formulario para convertirlos
     * a un objeto de tipo Permiso
     * @param objetoDTO los datos del formulario
     * @return el objeto Permiso creado
     */
    public void convertirDTO(Permiso permiso, PermisoDTO objetoDTO);

    /**
     * Persiste un objeto del tipo Usuario
     * @param permiso objeto a persistir
     * @return el objeto persistido
     */
    public Permiso guardar(Permiso permiso);

    /**
     * Lista todos los permisos que existen
     * @return
     */
    public List<Permiso> listar();

    /**
     * Verifica si existe un permiso a traves de su id
     * @param id del permiso
     * @return el permiso si existe
     */
    public Permiso existePermiso(Long id);

    public void eliminarPermiso(Permiso permiso);

}
