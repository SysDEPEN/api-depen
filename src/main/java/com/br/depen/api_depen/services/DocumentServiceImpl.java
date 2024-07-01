package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Documents;
import com.br.depen.api_depen.repository.DocumentRepository;
import com.br.depen.api_depen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Documents save(Documents documents) {

        try{
            return documentRepository.save(documents);
        }
        catch (Exception e){
            throw new RuntimeException("document not saved");
        }
    }

    @Override
    public List<Documents> findAll() {
            return documentRepository.findAll();
    }

    @Override
    public Optional<Documents> findById(Long id) {
        if(documentRepository.findById(id).isEmpty()){
            throw new RuntimeException("document not found with id " + id);
        }
        return documentRepository.findById(id);
    }

    @Override
    public Documents update(Documents documents) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
