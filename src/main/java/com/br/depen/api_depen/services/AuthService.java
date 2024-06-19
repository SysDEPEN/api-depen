package com.br.depen.api_depen.services;

import com.br.depen.api_depen.controller.LoginDto;
import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.repository.LoginRepository;
import com.br.depen.api_depen.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtils jwt;

    @Autowired
    private LoginRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(LoginDto usuario) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(usuario.username(), usuario.password()));
        var user = userRepository.findByNome(usuario.username());
        return getToken(user);
    }

    public String getToken(Login user) {
        String accessToken = jwt.generate(user, "ACCESS");
        return accessToken;
    }
}
