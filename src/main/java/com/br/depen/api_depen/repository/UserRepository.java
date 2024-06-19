package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}