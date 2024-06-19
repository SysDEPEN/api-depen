package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.SubInMostVisit;
import com.br.depen.api_depen.services.SubInMostVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class SubInMostVisitController {

    @Autowired
    private SubInMostVisitService subInMostVisitService;

    @GetMapping
    public ResponseEntity<List<SubInMostVisit>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SubInMostVisit>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubInMostVisit> create(@RequestBody SubInMostVisit subInMostVisit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subInMostVisitService.save(subInMostVisit));
    }

    @PutMapping
    public ResponseEntity<SubInMostVisit> update(@RequestBody SubInMostVisit subInMostVisit) {
        return ResponseEntity.status(HttpStatus.OK).body(subInMostVisitService.update(subInMostVisit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        subInMostVisitService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}