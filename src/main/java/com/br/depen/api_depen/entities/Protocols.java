package com.br.depen.api_depen.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "protocolos")
public class Protocols {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;

    @Column(nullable = false)
    private int id_requerimento_info;

    @Column(nullable = false)
    private int id_documento;

    @Column (nullable = false)
    private int status;
}
