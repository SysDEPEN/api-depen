package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.services.AuthService;
import com.br.depen.api_depen.services.LoginService;
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
        System.out.println(login);
        var token = authService.login(login);
        return ResponseEntity.ok(token);
    }

    @GetMapping("logins")
    public ResponseEntity<List<Login>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Login>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        loginService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
