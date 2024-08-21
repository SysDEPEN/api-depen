package com.br.depen.api_depen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 256)
    private String name;

    @Getter
    @Column(length = 14)
    private String document;

    @Column(length = 254)
    private String gender;

    private Date data_birth;

    @Column(length = 256)
    private String email;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(nullable = false)
    private Short role;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private List<Protocols> protocols;

    @OneToOne
    @JsonIgnoreProperties
    private Address address;

    @OneToOne
    @JsonIgnoreProperties
    private Documents doc;
}
