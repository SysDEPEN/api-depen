package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByNome(String username);
}