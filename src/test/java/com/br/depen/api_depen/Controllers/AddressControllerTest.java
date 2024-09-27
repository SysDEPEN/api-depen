package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.AddressController;
import com.br.depen.api_depen.controller.AdminController;
import com.br.depen.api_depen.controller.UserController;
import com.br.depen.api_depen.entities.Address;
import com.br.depen.api_depen.entities.Admin;
import com.br.depen.api_depen.entities.User;
import com.br.depen.api_depen.repository.AddressRepository;
import com.br.depen.api_depen.repository.AdminRepository;
import com.br.depen.api_depen.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AddressControllerTest {

    @Autowired
    AddressController addressController;

    @Autowired
    UserController userController;

    UserRepository userRepository;

    @MockBean
    AddressRepository addressRepository;

    Address address = new Address();

    @BeforeEach
    void setup(){
        address.setUF("PR");
        address.setCep("85884-000");
        address.setStreet("rua tal");
        address.setCountry("Brasil");
        address.setNumber_house("1260");
        address.setCity("Medianeira");
        address.setDistrict("bairro");
    }

    @Test
    void saveAddress() {
        ResponseEntity<Address> retorno = addressController.create(address);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    @DisplayName("ENDEREÇO ESTÁ COM CEP INVÁLIDO")
    void saveCepError() {
        Address addressFail = new Address();
        addressFail.setCep("xxzcxdasd");
        addressFail.setUF("PR");
        addressFail.setStreet("rua tal");
        addressFail.setCountry("Brasil");
        addressFail.setNumber_house("1260");
        addressFail.setCity("Medianeira");
        addressFail.setDistrict("bairro");


        assertThrows(Exception.class, ()-> {
            ResponseEntity<Address> message = addressController.create(addressFail);
        });
    }

    @Test
    @DisplayName("ENDEREÇO ESTÁ COM UF INVÁLIDO")
    void saveUFError() {
        Address addressFail = new Address();
        addressFail.setCep("85884-000");
        addressFail.setUF("ASD");
        addressFail.setStreet("rua tal");
        addressFail.setCountry("Brasil");
        addressFail.setNumber_house("1260");
        addressFail.setCity("Medianeira");
        addressFail.setDistrict("bairro");


        assertThrows(Exception.class, ()-> {
            ResponseEntity<Address> message = addressController.create(addressFail);
        });
    }


    @Test
    @DisplayName("NADA ENCONTRADO NO ENDEREÇO BAD REQUEST")
    void notFoundAddress() {
        Address addressF = null;

        ResponseEntity<Address> retorno = addressController.create(addressF);
        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
    }
}