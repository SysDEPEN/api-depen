package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<File, Long> { }