package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.UserController;
import com.br.depen.api_depen.entities.User;
import com.br.depen.api_depen.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
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
public class UserControllerTest {
    @Autowired
    UserController userController;

    @MockBean
    UserRepository userRepository;

    User user = new User();



    @BeforeEach
    void setup() {
        Short role = 1;
        user.setId(1L);
        user.setName("Test");
        user.setDocument("123456789002");
        user.setEmail("kwanza@email.com");
        user.setPassword("123456");
        user.setRole(role);
        user.setCreated_at(LocalDateTime.parse("2024-06-24T22:32:00"));
        user.setUpdated_at(LocalDateTime.parse("2024-06-24T22:32:00"));
    }

    @Test
    void saveUser() {
        ResponseEntity<User> retorno = userController.create(user);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    void saveUserError() {
        User userFailed = new User();
        userFailed.setEmail("asdasd");

        assertThrows(Exception.class, ()-> {
            ResponseEntity<User> message = userController.create(userFailed);
        });
    }
}
