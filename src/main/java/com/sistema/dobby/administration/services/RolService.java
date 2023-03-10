package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administration.model.dto.RolDTO;
import com.sistema.dobby.administration.model.Rol;

import java.util.List;

public interface RolService {

    /**
     * Este método mapea los datos de un formulario para convertirlos
     * a un objeto de tipo Rol
     * @param rol para la entidad
     * @param objetoDTO los datos del formulario
     * @return el objeto Rol creado
     */
    public void convertirDTO(Rol rol, RolDTO objetoDTO);

    /**
     * Persiste un objeto del tipo Usuario
     * @param rol objeto a persistir
     * @return el objeto persistido
     */
    public Rol guardar(Rol rol);

    /**
     * Lista todos los roles que existen
     * @return
     */
    public List<Rol> listar();

    /**
     * Realiza una busqueda entre los roles creados
     * @param id identificador del rol a buscar
     * @return Rol encontrado o null.
     */
    public Rol existeRol(Long id);

    public void eliminarRol(Rol rol);

}
