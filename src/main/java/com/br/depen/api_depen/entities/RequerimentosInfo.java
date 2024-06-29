package com.br.depen.api_depen.entities;

import lombok.Data;
import jakarta.persistence.*;


public class RequerimentosInfo {

    @Data
    @Entity
    @Table(name = "requerimentos_info")
    public class RequerimentoInfo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 256)
        private String nome_visitado;

        @Column(length = 11)
        private String cpf_rne;

        @Column(nullable = false, length = 256)
        private String tipo_visitacao;

        @Column(nullable = false, length = 45)
        private String telefone;

        @Column(nullable = false, length = 256)
        private String estado;

        @Column(nullable = false, length = 256)
        private String cidade;

        @Column(nullable = false, length = 256)
        private String bairro;

        @Column(nullable = false, length = 256)
        private String rua;

        @Column(nullable = false, length = 256)
        private String numero_casa;

        @Column(nullable = false, length = 256)
        private String requerimento_assunto;

        @Column(nullable = false)
        private int id_user;
    }

}
