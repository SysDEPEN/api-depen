package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.AdminController;
import com.br.depen.api_depen.entities.Admin;
import com.br.depen.api_depen.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AdminControllerTest {

    @Autowired
    AdminController adminController;

    @MockBean
    AdminRepository adminRepository;

    Admin admin = new Admin();

    @BeforeEach
    void setup(){
        Short role = 2;
        admin.setId(1L);
        admin.setName("Teste");
        admin.setDocument("121.893.509-05");
        admin.setEmail("farao@gmail.com");
        admin.setPassword("123456");
        admin.setRole(role);
        admin.setCreated_at(LocalDateTime.parse("2024-06-24T22:32:00"));
        admin.setUpdated_at(LocalDateTime.parse("2024-06-24T22:32:00"));
    }

    @Test
    void saveAdmin() {
        ResponseEntity<Admin> retorno = adminController.create(admin);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    @DisplayName("TESTE")
    void saveAdminError() {
        Admin adminFailed = new Admin();
        adminFailed.setEmail("xxzcxdasd");

        assertThrows(Exception.class, ()-> {
            ResponseEntity<Admin> message = adminController.create(adminFailed);
        });
    }
}