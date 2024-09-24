package com.br.depen.api_depen;

import com.br.depen.api_depen.DTOs.LoginDto;
import com.br.depen.api_depen.controller.LoginController;
import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.services.AuthService;
import com.br.depen.api_depen.services.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @MockBean
    private LoginService loginService;

    @MockBean
    private AuthService authService;

    @InjectMocks
    private LoginController loginController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetJwtByLogin_Success() throws Exception {
        LoginDto loginDto = new LoginDto("username", "password");
        String token = "fake-jwt-token";

        when(authService.login(any(LoginDto.class))).thenReturn(token);

        mockMvc.perform(post("/api/v1/logins/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Token").value(token));
    }

    @Test
    void testGetJwtByLogin_Unauthorized() throws Exception {
        LoginDto loginDto = new LoginDto("invalidUsername", "invalidPassword");

        when(authService.login(any(LoginDto.class))).thenThrow(new RuntimeException("Unauthorized"));

        mockMvc.perform(post("/api/v1/logins/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Unauthorized"));
    }

    @Test
    void testFindAllLogins() throws Exception {
        Login login = new Login();
        login.setNome("username");

        when(loginService.findAll()).thenReturn(Collections.singletonList(login));

        mockMvc.perform(get("/api/v1/logins/logins")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("username"));
    }

    @Test
    void testFindLoginById_Success() throws Exception {
        Login login = new Login();
        login.setId(1L);
        login.setNome("username");

        when(loginService.findById(1L)).thenReturn(Optional.of(login));

        mockMvc.perform(get("/api/v1/logins/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("username"));
    }

    @Test
    void testFindLoginById_NotFound() throws Exception {
        when(loginService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/logins/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Aqui, retornaria uma resposta 404 em uma API real
                .andExpect(content().string(""));
    }

    @Test
    void testDeleteLogin_Success() throws Exception {
        doNothing().when(loginService).deleteById(1L);

        mockMvc.perform(delete("/api/v1/logins/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(loginService, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteLogin_ThrowsException() throws Exception {
        doThrow(new RuntimeException("Generic error")).when(loginService).deleteById(1L);

        mockMvc.perform(delete("/api/v1/logins/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Generic error"));
    }
}
