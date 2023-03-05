package com.sistema.dobby.repository;

import com.sistema.dobby.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public Usuario findByIdUsuario(Long idUsuario);

}
