package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String name;

    @Column(length = 14)
    @CPF
    @NotBlank
    private String document;

    @Column(length = 256)
    @Email
    private String email;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String password;

    @Column(nullable = false)
    private Short role;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @OneToMany
    @JsonIgnoreProperties
    private List<Protocols> protocols;
}
