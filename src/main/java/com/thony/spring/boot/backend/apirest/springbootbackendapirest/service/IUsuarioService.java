package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
