package com.guilhermesantos.agendador.infrastructure.security;


import com.guilhermesantos.agendador.business.DTO.UsuarioDTO;
import com.guilhermesantos.agendador.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token){

        UsuarioDTO usuarioDTO = client.buscarUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail()) //Define o nome de usuário como o email
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build();
    }
}
