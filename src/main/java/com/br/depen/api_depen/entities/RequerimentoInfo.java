package com.br.depen.api_depen.entities;

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
    private String nome_visitado;

    @Column()
    private String cpf_rne;

    @Column(nullable = false)
    private String tipo_visitacao;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero_casa;

    @Column(nullable = false)
    private String requerimento_assunto;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;
    
}
