/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 2021122760232
 */
@Entity
public class ProdutoPedido implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idProdutoPedido;
    
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn (name = "idProduto")
    private Produto produto;
    
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn (name = "idPedido")
    private Pedido pedido;
    
    @Column (name="qtd", nullable = false)
    private int qtd;
    
    @Column (name="preco", nullable = false)
    private double preco;

    public int getIdProdutoPedido() {
        return idProdutoPedido;
    }

    public void setIdProdutoPedido(int idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
