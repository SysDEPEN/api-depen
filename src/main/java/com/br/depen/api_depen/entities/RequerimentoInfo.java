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

    @Column()
    private String name_visited;

    @Column()
    private String cpf_rne;

    @Column()
    private String type_visitation;

    @Column()
    private String cellphone;

    @Column()
    private String state;

    @Column()
    private String city;

    @Column()
    private String district;

    @Column()
    private String street;

    @Column()
    private String number_house;

    @OneToOne
    @JsonIgnoreProperties
    private Subject subject;

}
