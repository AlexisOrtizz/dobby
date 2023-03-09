package com.sistema.dobby.administracion.repository;

import com.sistema.dobby.administration.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {

    public Permiso findByIdPermiso(Long idPermiso);
    public Permiso findByNombre(String nombre);

}
