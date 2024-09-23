package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.services.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.br.depen.api_depen.entities.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/v1/upload")
public class FileUploadController {

    private DocumentsController documentsController;

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    @PostMapping
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        try {
            // Process the file, for example, save it to a directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get("uploads/" + file.getOriginalFilename());
            Files.write(path, bytes);
            File fileNew = new File();
            fileNew.setFilePath(file.getOriginalFilename());

            fileUploadService.save(fileNew);
            return ResponseEntity.ok(file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file. " + e.getMessage() );
        }
    }

    

    @GetMapping
    public ResponseEntity<File> findAllFiles(@RequestParam)

}
