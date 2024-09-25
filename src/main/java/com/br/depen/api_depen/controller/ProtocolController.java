package com.br.depen.api_depen.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.depen.api_depen.entities.Protocols;
import com.br.depen.api_depen.services.ProtocoloService;

@RestController
@RequestMapping("api/v1/protocols")
public class ProtocolController {
    @Autowired
    private ProtocoloService protocoloService;

    @GetMapping
    public ResponseEntity<List<Protocols>> findAll() {
        return ResponseEntity.ok(protocoloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protocols> findById(@PathVariable Long id) {
        return protocoloService.findById(id)
            .map(protocols -> ResponseEntity.ok(protocols))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Protocols> create(@RequestBody @Valid Protocols protocols) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(protocoloService.save(protocols));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Protocols> update(@PathVariable Long id, @RequestBody Protocols protocols) {
        protocols.setId(id); // Ensure the ID is set for the update
        return ResponseEntity.ok(protocoloService.update(protocols));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (protocoloService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
