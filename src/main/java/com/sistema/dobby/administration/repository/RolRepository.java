package com.sistema.dobby.administracion.repository;

import com.sistema.dobby.administration.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    public Rol findByIdRol(Long idRol);
    public Rol findByNombre(String nombre);

}
