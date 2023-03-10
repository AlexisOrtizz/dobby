package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administration.model.dto.UsuarioDTO;
import com.sistema.dobby.administration.model.Permiso;
import com.sistema.dobby.administration.model.Rol;
import com.sistema.dobby.administration.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UsuarioService extends UserDetailsService {

    /**
     * Este método mapea los datos de un formulario para convertirlos
     * a un objeto de tipo Usuario
     * @param objetoDTO los datos del formulario
     * @return el objeto Usuario creado
     */
    public void convertirDTO(Usuario usuario, UsuarioDTO objetoDTO);

    /**
     * Persiste un objeto del tipo Usuario
     * @param usuario objeto a persistir
     * @return el objeto persistido
     */
    public Usuario guardar(Usuario usuario);

    /**
     * Lista todos los usuarios que existen
     * @return
     */
    public List<Usuario> listarUsuarios();

    /**
     * Verifica si existe un usuario a traves de su correo
     * @param email del usuario
     * @return el usuario si existe
     */
    public Usuario existeUsuario(String email);

    /**
     * Cambia el rol de un usuario
     * @param usuario a quien se le cambia el rol
     * @param rol a ser asignado al usuario
     * @return boolean
     */
    public boolean camibarRol(Usuario usuario, Rol rol);

    public void crearAdmin();

    public Set<Permiso> verPermisosUsuarioActual();

    public boolean tienePermiso(String permiso);

    public Usuario obtenerUsuario(Long id);

    public void eliminarUsuario(Usuario usuario);

}
