package com.br.depen.api_depen.services;

import com.br.depen.api_depen.controller.LoginDto;
import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.entities.User;
import com.br.depen.api_depen.repository.LoginRepository;
import com.br.depen.api_depen.repository.UserRepository;
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
    private UserRepository userRepository;

    public String login(LoginDto usuario) {
        User user = userRepository.findByDocumento(usuario.getDocument());
        if (user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        if (!user.getSenha().equals(usuario.getPassword())) {
            throw new RuntimeException("Usuario ou Senha inválida");
        }
        //return user.getId().toString();
        return getToken(user);
    }

    public String getToken(User user) {
        return jwt.generate(user, "ACCESS");
    }
}
