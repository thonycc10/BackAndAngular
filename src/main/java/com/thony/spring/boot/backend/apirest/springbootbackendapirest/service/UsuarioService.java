package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao.IUsuarioDao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//spring security
@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioDao.findByUsername(username);

        if ( usuario == null ) {
            logger.error("Error en el login: no existe el usuario: '" + username + "' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario: '" + username + "' en el sistema");
        }

        // se convirtio un list o array roles a un list de clase GrandtedAuthority
        List<GrantedAuthority> authorityList = usuario.getRoles()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getNombre()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnable(), true, true, true, authorityList);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return iUsuarioDao.findByUsername(username);
    }
}
