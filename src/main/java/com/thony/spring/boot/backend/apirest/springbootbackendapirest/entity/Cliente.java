package com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column() se usa si el campo de la tabla tiene nombre difeente

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 1, max = 12, message = "el tamaño tiene que estar entre 4 y 12 caracteres")
    @Column(nullable=false)
    private String name;

    @NotEmpty(message = "No puede estar vacio")
    private String apellido;

    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No es la dirección adecuada del correo")
    @Column(nullable=false,unique=false) // no acepta null y sea unico
    private String email;

    @NotNull(message = "No puede estar vacio")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)  // transforma la fecha de java a sql
    private Date createAt;

    // la region no puede estar vacia
    @NotNull(message = "la región no puede ser vacia")
    // mappear m:1 por que muchos clientes en una region
    // lazy -> carga perezosa para que solo se cague si es llamado, se ggenera un proxy
    @ManyToOne(fetch=FetchType.LAZY)
    // creamos la llave forania si lo omitimos por defecto le añade un nombre
    @JoinColumn(name = "region_id")
    // por lazy se debe omitar estos atributos por eso se usa esta inyeccion
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    private String foto;
    //@PrePersist // ayuda a crear automaticamente la fech actual de un registro
    //public void prePersist() {
    //    createAt = new Date();
    //}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long seriaLVersionUID = 1L;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
