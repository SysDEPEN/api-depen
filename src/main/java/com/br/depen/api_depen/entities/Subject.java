package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties
    private SubjectInmostVisit id_inmost_visit;

    @Column()
    private LocalDateTime created_at;

    @Column()
    private LocalDateTime updated_at;
}
