package com.sistema.dobby.repository;

import com.sistema.dobby.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {

    public Permiso findByIdPermiso(Long idPermiso);

}
