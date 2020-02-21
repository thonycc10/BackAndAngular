package com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

//    en numero 1 es la posicion del parametro de la funcion
    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsername2(String username);

}
