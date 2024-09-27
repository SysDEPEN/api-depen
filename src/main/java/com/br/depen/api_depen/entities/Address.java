package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;



@Data
@Entity
@Table(name = "tb_address")
public class Address {
    // Regex pattern para UF
    public static final String UF_REGEX = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 9)
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP deve estar no formato 00000-000")
    private String cep;

    @Column(nullable = false, length = 256)
    @NotBlank
    private String country;

    @Column(nullable = false, length = 2)
    @Pattern(regexp = UF_REGEX, message = "UF inválida. Deve ser uma sigla de UF válida do Brasil.")
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
