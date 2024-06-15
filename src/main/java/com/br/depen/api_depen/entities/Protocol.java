package com.br.depen.api_depen.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "protocolos")
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}