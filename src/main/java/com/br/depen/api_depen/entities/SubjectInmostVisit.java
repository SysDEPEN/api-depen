package com.br.depen.api_depen.entities;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tb_subject_inmost_visit")
public class SubjectInmostVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean cumplice;

    @Column(nullable = false)
    private Boolean vitima;

    @Column(nullable = false)
    private Boolean gravida;

    private Short tempo_gravidez;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;
}
