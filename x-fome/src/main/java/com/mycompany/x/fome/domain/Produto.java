/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author prisc
 */
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idProduto;
    
    @ManyToOne
    @JoinColumn (name = "idCategoria")
    private Categoria categoria;
    
    @Column (name="nomeProduto", length = 250, nullable = false)
    private String nomeProduto;
    
    @Column (name="ingredientes", length = 250, nullable = false)
    private String ingredientes;
    
    @Column (name="preco", nullable = false)
    private double preco;
    
    public Produto(){
        
    }
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nomeProduto + " , ingredientes: " + ingredientes + ",  R$ " + preco;
    }
    
}
