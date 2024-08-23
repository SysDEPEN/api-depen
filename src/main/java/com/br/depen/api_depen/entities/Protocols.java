package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_protocols")
public class Protocols {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @ManyToOne
    @JsonIgnoreProperties
    private User user;

    @OneToOne
    @JsonIgnoreProperties
    private RequerimentoInfo req_info;

    @OneToOne
    @JsonIgnoreProperties
    private Documents doc;

    @ManyToOne
    @JsonIgnoreProperties
    private Admin admin;

    @NotNull
    @Column (nullable = false)
    private Long status;
}
