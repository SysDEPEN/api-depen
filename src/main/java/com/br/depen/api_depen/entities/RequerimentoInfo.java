package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_requerimento_info")
public class RequerimentoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name_visited;

    @Column()
    private String cpf_rne;

    @Column(nullable = false)
    private String type_visitation;

    @Column(nullable = false)
    private String cellphone;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number_house;

    @OneToOne
    @JsonIgnoreProperties
    private Subject subject;

}
