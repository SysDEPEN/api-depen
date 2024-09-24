package com.br.depen.api_depen.DTOs;

public class LoginDto {
    private String document;
    private String password;

    // Construtor com parâmetros
    public LoginDto(String document, String password) {
        this.document = document;
        this.password = password;
    }

    // Getters
    public String getDocument() {
        return document;
    }

    public String getPassword() {
        return password;
    }
}
