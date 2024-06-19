package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Documents;


import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Documents save(Documents documents);

    List<Documents> findAll();

    Optional<Documents> findById(Long id);

    Documents update (Documents documents);

    void deleteById(Long id);
}
