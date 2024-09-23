package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.File;
import com.br.depen.api_depen.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public File save(File file) {
        return fileUploadRepository.save(file);
    }

    @Override
    public List<File> findaAll() {
        return fileUploadRepository.findAll();
    }

    @Override
    public Optional<File> findById(Long id) {
        return fileUploadRepository.findById(id);
    }

    @Override
    public void DeleteById(Long id) {
        fileUploadRepository.deleteById(id);
    }
}
