package com.sistema.dobby.repository;

import com.sistema.dobby.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

    public Rol findByIdRol(Long idRol);

}
