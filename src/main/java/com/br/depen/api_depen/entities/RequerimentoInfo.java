package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_requerimento_info")
public class RequerimentoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name_visited;

    @NotBlank
    @Column()
    private String cpf_rne;

    @NotBlank
    @Column(nullable = false)
    private String type_visitation;

    @NotBlank
    @Column(nullable = false)
    private String cellphone;

    @NotBlank
    @Column(nullable = false)
    private String state;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String district;

    @NotBlank
    @Column(nullable = false)
    private String street;

    @NotBlank
    @Column(nullable = false)
    private String number_house;

    @OneToOne
    @JsonIgnoreProperties
    private Subject subject;

}
