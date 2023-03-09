package com.sistema.dobby.administracion.repository;

import com.sistema.dobby.administration.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public Usuario findByUsername(String username);
    public Usuario findByIdUsuario(Long idUsuario);

}
