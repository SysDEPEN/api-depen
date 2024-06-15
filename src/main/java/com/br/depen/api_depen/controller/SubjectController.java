package com.br.depen.api_depen.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.depen.api_depen.entities.Subject;
import com.br.depen.api_depen.service.SubjectService;

@RestController
@RequestMapping("api/v1/users")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Subject>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(subject));
    }

    @PutMapping
    public ResponseEntity<Subject> update(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.update(subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        subjectService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}