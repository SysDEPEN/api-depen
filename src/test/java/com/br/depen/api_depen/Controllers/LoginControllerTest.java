package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.DTOs.LoginDto;
import com.br.depen.api_depen.controller.LoginController;
import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.repository.LoginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginControllerTest {

    @Autowired
    LoginController loginController;

    @MockBean
    LoginRepository loginRepository;

    LoginDto login = new LoginDto();

    @BeforeEach
    void setup(){


    }

    @Test
    void saveLogin() {
        ResponseEntity<String> retorno = loginController.getJwtByLogin(login);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    @DisplayName("Teste login")
    void saveLoginError() {
        Login loginFailed = new Login();
        loginFailed.setDocument("3123214141");
    }
}
