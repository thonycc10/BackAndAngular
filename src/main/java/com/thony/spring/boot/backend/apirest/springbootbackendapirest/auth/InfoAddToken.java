package com.thony.spring.boot.backend.apirest.springbootbackendapirest.auth;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Usuario;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.IUsuarioService;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class InfoAddToken implements TokenEnhancer {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Usuario usuario = usuarioService.findByUsername(oAuth2Authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("id_user", usuario.getId());
        info.put("status", usuario.isEnable());
        info.put("name", usuario.getNombre());
        info.put("surname", usuario.getApellido());
        info.put("email", usuario.getEmail());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }

}
