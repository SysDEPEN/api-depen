package com.br.depen.api_depen.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String pais;

    private String UF;

    private String cidade;

    private String bairro;

    private String rua;

    @Column(name = "numero_casa")
    private String numeroCasa;
}