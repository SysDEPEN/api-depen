package com.br.depen.api_depen.controller;

import com.br.depen.api_depen.entities.Address;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.br.depen.api_depen.services.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/address")
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody @Valid Address address) {
        try{
            if(address == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
