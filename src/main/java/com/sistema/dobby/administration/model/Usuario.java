package com.sistema.dobby.administration.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@Entity
@Table(name = "db_usuario", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    /* ************************ */
    /* RELACIONES ENTRE OBJETOS */
    /* ************************ */

    @ManyToMany
    @JoinTable(name = "usuario_roles",
        joinColumns = @JoinColumn(
            name = "usuario_id", referencedColumnName = "idUsuario"),
        inverseJoinColumns = @JoinColumn(
            name = "rol_id", referencedColumnName = "idRol")
    )
    private Collection<Rol> roles;

}
