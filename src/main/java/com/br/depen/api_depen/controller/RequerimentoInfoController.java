package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.RequerimentoInfo;
import com.br.depen.api_depen.services.RequerimentoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/req_camp")
public class RequerimentoInfoController {

    @Autowired
    private RequerimentoInfoService requerimentoInfoService;

    @GetMapping
    public ResponseEntity<List<RequerimentoInfo>> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requerimentoInfoService.findAll());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RequerimentoInfo>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requerimentoInfoService.findById(id));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<RequerimentoInfo> create(@RequestBody RequerimentoInfo requerimentoInfo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(requerimentoInfoService.save(requerimentoInfo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<RequerimentoInfo> update(@RequestBody RequerimentoInfo requerimentoInfo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requerimentoInfoService.update(requerimentoInfo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            requerimentoInfoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
