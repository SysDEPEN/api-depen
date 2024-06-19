package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.SubjectInmostVisit;
import com.br.depen.api_depen.services.SubInMostVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user/subject2")
public class SubInMostVisitController {

    @Autowired
    private SubInMostVisitService subInMostVisitService;

    @GetMapping
    public ResponseEntity<List<SubjectInmostVisit>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SubjectInmostVisit>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubjectInmostVisit> create(@RequestBody SubjectInmostVisit subjectInMostVisit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subInMostVisitService.save(subjectInMostVisit));
    }

    @PutMapping
    public ResponseEntity<SubjectInmostVisit> update(@RequestBody SubjectInmostVisit subjectInmostVisit) {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.update(subjectInmostVisit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        subInMostVisitService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}