package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import com.br.depen.api_depen.entities.Subject;

public interface SubjectService {
	Subject save(Subject subject);

    List<Subject> findAll();

    Optional<Subject> findById(Long id);

    Subject update (Subject subject);

    void deleteById(Long id);
}