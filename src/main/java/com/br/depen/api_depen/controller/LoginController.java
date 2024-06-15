package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.service.AuthService;
import com.br.depen.api_depen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/logins")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> getJwtByLogin(@RequestBody LoginDto login){
        var token = authService.login(login);
        return ResponseEntity.ok(token);
    }

    @GetMapping
    public ResponseEntity<List<Login>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Login>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Login> create(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login));
    }

    @PutMapping
    public ResponseEntity<Login> update(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.update(login));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        loginService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
