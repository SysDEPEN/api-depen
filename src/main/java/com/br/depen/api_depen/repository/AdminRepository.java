package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
