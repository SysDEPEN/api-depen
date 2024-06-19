package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Login;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    Login save(Login login);

    List<Login> findAll();

    Optional<Login> findById(Long id);

    Login update (Login login);

    void deleteById(Long id);
}
