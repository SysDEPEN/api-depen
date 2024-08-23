package com.br.depen.api_depen.entities;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(nullable = false)
    private Boolean accomplice;

    @NotNull
    @Column(nullable = false)
    private Boolean victim;

    @NotNull
    @Column(nullable = false)
    private Boolean pregnancy;

    @NotNull
    private Short time_pregnancy;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;
}
