package com.br.depen.api_depen.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "tb_login")
public class Login{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String nome;

    @Column(length = 14)
    @Pattern(regexp = "(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(\\d{11})|(\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1})|(\\d{9})", message = "Documento inválido. Deve ser CPF ou RNE.")
    private String document;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String password;

    @Column(nullable = false)
    private Short role;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

}
