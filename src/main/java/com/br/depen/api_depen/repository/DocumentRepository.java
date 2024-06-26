package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.Documents;
import com.br.depen.api_depen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Documents, Long> {

}