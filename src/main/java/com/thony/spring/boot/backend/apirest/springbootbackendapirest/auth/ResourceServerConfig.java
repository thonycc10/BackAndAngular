package com.thony.spring.boot.backend.apirest.springbootbackendapirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // se comenta para que se añada las validaciones desde el controlador anotaciones.
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**").permitAll()
                /* .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN") // asignamos roles
                .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN") // asignamos roles
                .antMatchers("/api/clientes/**").hasRole("ADMIN") */ // asignamos de frente para los demas metodosHTTP
                .anyRequest().authenticated();
    }
}
