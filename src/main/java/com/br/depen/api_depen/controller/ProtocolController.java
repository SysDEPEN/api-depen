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
import com.br.depen.api_depen.entities.Protocol;
import com.br.depen.api_depen.service.ProtocoloService;

@RestController
@RequestMapping("api/v1/logins")
public class ProtocolController {
    @Autowired
    private ProtocoloService protocoService;

    @GetMapping
    public ResponseEntity<List<Protocol>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Protocol>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Protocol> create(@RequestBody Protocol protocol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(protocoService.save(protocol));
    }

    @PutMapping
    public ResponseEntity<Protocol> update(@RequestBody Protocol protocol) {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.update(protocol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        protocoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }