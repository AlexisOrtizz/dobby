package com.sistema.dobby.administration.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermiso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Permiso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String toString() {
        return this.nombre;
    }

    /* ************************ */
    /* RELACIONES ENTRE OBJETOS */
    /* ************************ */

    @ManyToMany(mappedBy = "permisos")
    private Collection<Rol> roles;

}
