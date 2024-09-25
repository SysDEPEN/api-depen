package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_protocols")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Protocols {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @ManyToOne
    private User user;

    @OneToOne
    private RequerimentoInfo req_info;

    @OneToOne
    private Documents doc;

    @ManyToOne
    private Admin admin;

    @NotNull
    @Column(nullable = false)
    private Long status;

}
