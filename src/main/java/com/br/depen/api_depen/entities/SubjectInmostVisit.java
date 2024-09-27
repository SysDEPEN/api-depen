package com.br.depen.api_depen.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tb_subject_inmost_visit")
public class SubjectInmostVisit {

    // Regex pattern para tempo de gravidez (1 a 10 meses)
    public static final String GRAVIDEZ_REGEX = "^(0?[1-9]|10)$";
    public static final String ACQUISITION_REGEX = "^(sim|não)$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = ACQUISITION_REGEX, message = "O valor deve ser 'sim' ou 'não'.")
    private String accomplice;

    @NotNull
    @Column(nullable = false)
    private Boolean victim;

    @NotNull
    @Column(nullable = false)
    private Boolean pregnancy;

    @NotNull
    @Pattern(regexp = GRAVIDEZ_REGEX, message = "O tempo de gravidez deve estar entre 1 e 10 meses. Mais que isso você ta plantando soja na barriga")
    private String time_pregnancy;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;
}
