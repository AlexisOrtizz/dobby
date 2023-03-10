package com.sistema.dobby.administracion.services;

import com.sistema.dobby.administracion.util.GeneralUtils;
import com.sistema.dobby.administration.model.dto.UsuarioDTO;
import com.sistema.dobby.administration.model.Permiso;
import com.sistema.dobby.administration.model.Rol;
import com.sistema.dobby.administration.model.Usuario;
import com.sistema.dobby.administracion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolServiceImp rolService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void convertirDTO(Usuario usuario, UsuarioDTO objetoDTO) {
        usuario.setUsername(objetoDTO.getUser());
        usuario.setEmail(objetoDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(objetoDTO.getPassword()));
        return;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Del formulario Login trae el username, luego busca en la base de datos para
     * agregar el usuario como Current User en el Spring Security con su respectos
     * permisos.
     * @param username correo electronico del usuario
     * @return Spring Security User
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inv??lido");
        }

        return new User(usuario.getEmail(), usuario.getPassword(), mapearPermisos(usuario.getRoles()));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        /* retorna una lista con todos los usuarios */
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario existeUsuario(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario existeUsuario(Long id) {
        Usuario usuario = null;
        try {
            return usuarioRepository.findByIdUsuario(id);
        } catch (Exception e) {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public boolean camibarRol(Usuario usuario, Rol rol) {
        return false;
    }

    @Override
    public void crearAdmin() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUser(GeneralUtils.ADMIN_USER);
        usuarioDTO.setEmail(GeneralUtils.ADMIN_EMAIL);
        usuarioDTO.setPassword(GeneralUtils.ADMIN_PASS);

        Usuario usuario = new Usuario();
        convertirDTO(usuario, usuarioDTO);
        guardar(usuario);
        usuario.getRoles().add(rolService.crearAdmin());
        guardar(usuario);

        System.out.println(usuario);

    }

    @Override
    public Set<Permiso> verPermisosUsuarioActual() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = this.existeUsuario(username);

        if(usuario == null) {
            return null;
        }

        return null;//usuario.getRol().getPermisos();
    }

    @Override
    public boolean tienePermiso(String permiso) {
        for(Permiso aux : this.verPermisosUsuarioActual()) {
            if(permiso.equals(aux.toString())) return true;
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findByIdUsuario(id);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return;
    }

    private Collection<? extends GrantedAuthority> mapearPermisos(Collection<Rol> roles) {
        /* Mapea cada permiso del usuario a una lista para que Spring security reconozca como
         * permiso en el sistema.
         * */
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        for(Rol rol : roles) {
            for(Permiso permiso : rol.getPermisos()) {
                authorities.add(new SimpleGrantedAuthority(permiso.toString()));
            }
        }

        System.out.println("=== Roles ===");
        System.out.println(authorities);
        System.out.println("=== fin ===");

        return authorities;

    }
}
