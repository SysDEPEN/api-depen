package com.br.depen.api_depen.entities;

import jakarta.validation.constraints.NotBlank;
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
    @CPF
    @NotBlank
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
