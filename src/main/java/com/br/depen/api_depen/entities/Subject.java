package com.br.depen.api_depen.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tb_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256)
    private String subject;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_inmost_visit", nullable = false)
    private SubjectInmostVisit id_inmost_visit;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;
}
