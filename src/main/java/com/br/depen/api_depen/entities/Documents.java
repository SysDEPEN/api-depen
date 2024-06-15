package com.br.depen.api_depen.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentos;

    @Column
    private Date createdAt;

    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;
}
