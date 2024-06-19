package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    User update (User user);

    void deleteById(Long id);
}
