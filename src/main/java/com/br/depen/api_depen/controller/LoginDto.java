package com.br.depen.api_depen.controller;

public record LoginDto(
        String username,
        String password
) {
    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}