package com.br.depen.api_depen.entities;

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
    private String cep;

    @Column(nullable = false, length = 256)
    private String pais;

    @Column(nullable = false, length = 2)
    private String UF;

    @Column(nullable = false, length = 256)
    private String cidade;

    @Column(nullable = false, length = 256)
    private String bairro;

    @Column(nullable = false, length = 256)
    private String rua;

    @Column(nullable = false, length = 256)
    private String numero_casa;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;
}
