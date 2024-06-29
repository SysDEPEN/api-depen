package com.br.depen.api_depen.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_requerimento_info")
public class RequerimentoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_visitado;

    @Column()
    private String cpf_rne;

    @Column(nullable = false)
    private String tipo_visitacao;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero_casa;

    @Column(nullable = false)
    private String requerimento_assunto;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User id_user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_visitado() {
        return nome_visitado;
    }

    public void setNome_visitado(String nome_visitado) {
        this.nome_visitado = nome_visitado;
    }

    public String getCpf_rne() {
        return cpf_rne;
    }

    public void setCpf_rne(String cpf_rne) {
        this.cpf_rne = cpf_rne;
    }

    public String getTipo_visitacao() {
        return tipo_visitacao;
    }

    public void setTipo_visitacao(String tipo_visitacao) {
        this.tipo_visitacao = tipo_visitacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getRequerimento_assunto() {
        return requerimento_assunto;
    }

    public void setRequerimento_assunto(String requerimento_assunto) {
        this.requerimento_assunto = requerimento_assunto;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }
}
