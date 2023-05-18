/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 2021122760232
 */
@Entity

public class Pedido implements Serializable  {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPedido;
    
    @ManyToOne
    @JoinColumn (name = "idUsuario")
    private Usuario cliente;

    public Pedido() {
    }
    
    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;
    
    @Temporal ( TemporalType.DATE )
    private Date data;
    
    @Column (name="endereco",length = 250, nullable = false)
    private String endereco;
    
    @Column (name="isRetirarNaLoja",nullable = false)
    private boolean isRetirarNaLoja;
    
    @OneToMany ( mappedBy = "pedido", fetch =  FetchType.LAZY)
    private List<ProdutoPedido> produtos;
    
    @Column (name="taxaEntrega", nullable = false)
    private double taxa_entrega;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public Pedido(Usuario cliente, Status status, Date data, String endereco, boolean isRetirarNaLoja, List<ProdutoPedido> produtos, double taxa_entrega) {
        this.cliente = cliente;
        this.status = status;
        this.data = data;
        this.endereco = endereco;
        this.isRetirarNaLoja = isRetirarNaLoja;
        this.produtos = produtos;
        this.taxa_entrega = taxa_entrega;
    }

    
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

    public double getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(double taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
    }
    
}
