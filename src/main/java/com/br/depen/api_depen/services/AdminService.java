package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Admin save(Admin admin);

    List<Admin> findAll();

    Optional<Admin> findById(Long id);

    Admin update (Admin admin);

    void deleteById(Long id);
}
