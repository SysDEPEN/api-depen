package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.File;

import java.util.List;
import java.util.Optional;

public interface FileUploadService {
    File save(File file);

    List<File> findaAll();

    Optional<File> findById(Long id);

    void DeleteById(Long id);
}
