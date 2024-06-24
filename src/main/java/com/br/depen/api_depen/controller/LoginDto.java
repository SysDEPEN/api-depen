package com.br.depen.api_depen.controller;

public class LoginDto {
    public String username;
    public String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}