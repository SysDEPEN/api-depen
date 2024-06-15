package com.br.depen.api_depen.entities;

import java.util.Date;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tb_subject_inmost_visit")
public class SubInMostVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean cumplice;

    private boolean vitima;

    private boolean gravida;

    @Column(name = "tempo_gravidez")
    private int tempoGravidez;

    private User user;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}