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
    private Boolean accomplice;

    @Column(nullable = false)
    private Boolean victim;

    @Column(nullable = false)
    private Boolean pregnancy;

    private Short time_pregnancy;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;
}
