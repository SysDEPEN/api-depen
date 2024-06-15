package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/documents")
public class DocumentsController {

    @Autowired
    private DocumentsService documentsService;

    @GetMapping
    public ResponseEntity<List<Documents>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(documentsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Documents>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(documentsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Documents> create(@RequestBody Documents documents) {
        return ResponseEntity.status(HttpStatus.CREATED).body(documentsService.save(documents));
    }

    @PutMapping
    public ResponseEntity<Documents> update(@RequestBody Documents documents) {
        return ResponseEntity.status(HttpStatus.OK).body(documentsService.update(documents));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        documentsService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
