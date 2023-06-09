/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 2021122760232
 */
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column (name="nome", length = 250, nullable = false)
    private String nome;
    
    @Override
    public String toString() {
        return nome;
    }

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this};
    }
    
    @OneToMany ( mappedBy = "categoria", fetch =  FetchType.LAZY)
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }
}
