package com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity;

import javax.persistence.*;
import java.io.Serializable;
// se añade serializable por razones de utilizar json y comunicacion api rest
@Entity
@Table(name = "regiones")
public class Region implements Serializable {
    /*
    * 1 - crear los atributos
    * 2 - get y seters
    * 3 - añadir columns de la tabla
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private static final long serialVersionUID = 1L;
}
