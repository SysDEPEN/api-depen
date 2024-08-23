package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 9)
    @NotBlank
    private String cep;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String country;

    @Column(nullable = false, length = 2)
    @NotBlank
    private String UF;

    @Column(nullable = false , length = 256)
    @NotBlank
    private String city;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String district;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String street;

    @Column(nullable = false, length = 256)
    private String number_house;

    @OneToOne
    @JsonIgnoreProperties
    private User user;
}
