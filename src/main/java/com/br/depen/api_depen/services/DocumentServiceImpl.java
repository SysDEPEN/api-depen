package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Documents;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Override
    public Documents save(Documents documents) {
        return null;
    }

    @Override
    public List<Documents> findAll() {
        return null;
    }

    @Override
    public Optional<Documents> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Documents update(Documents documents) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
