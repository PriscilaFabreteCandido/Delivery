/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 2021122760232
 */
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column (name="nomeUsuario", length = 250, nullable = false)
    private String nomeUsuario;

    public Usuario() {
    }
    
    @Column (name="endereco", length = 250, nullable = false)
    private String endereco;
    
    @Column (name="cep", length = 250, nullable = false)
    private String cep;
    
    @Column (name="isCliente", nullable = false)
    private boolean isCliente;
    
    @Column (name="email", length = 250, nullable = false)
    private String email;
    
    @Column (name="senha", length = 250, nullable = false)
    private String senha;
     
    @Column (name="cidade", length = 250, nullable = false)
    private String cidade;
    
    @OneToMany ( mappedBy = "cliente", fetch =  FetchType.LAZY)
    private List<Pedido> pedidos;
    
    @Column (name="cpf", length = 250, nullable = false)
    private String cpf;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public boolean isIsCliente() {
        return isCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getCidade() {
        return cidade;
    }

    public Usuario(String nomeUsuario, String endereco, String cep, boolean isCliente, String email, String senha, String cidade, List<Pedido> pedidos, String cpf) {
        this.nomeUsuario = nomeUsuario;
        this.endereco = endereco;
        this.cep = cep;
        this.isCliente = isCliente;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.pedidos = pedidos;
        this.cpf = cpf;
        
    }

    public Usuario(String nomeUsuario, String endereco, String cep, boolean isCliente, String email, String senha, String cidade, String cpf) {
        this.nomeUsuario = nomeUsuario;
        this.endereco = endereco;
        this.cep = cep;
        this.isCliente = isCliente;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.cpf = cpf;
        this.pedidos = new ArrayList<Pedido>();
    }

    public Usuario(String nomeUsuario, String endereco) {
        this.nomeUsuario = nomeUsuario;
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
}
