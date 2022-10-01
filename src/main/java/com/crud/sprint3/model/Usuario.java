package com.crud.sprint3.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor //Constructor con todos los atributos
@NoArgsConstructor //Constructor vacio
@Getter //Genera los getters
@Setter //Genera los setters
@ToString //Genera el metodo toString
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "auth0id", unique = true)
    private String auth0id;

    public Usuario(String email, String imagen, String auth0id) {
        this.email = email;
        this.imagen = imagen;
        this.auth0id = auth0id;
    }
}
