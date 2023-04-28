/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;
    
    @Temporal ( TemporalType.DATE )
    private Date data;
    
    @Column (name="endereco",length = 250, nullable = false)
    private String endereco;
    
    @OneToMany ( mappedBy = "produto", fetch =  FetchType.LAZY)
    private ArrayList<ProdutoPedido> produtos;
    
    @Column (name="taxaEntrega", nullable = false)
    private double taxa_entrega;
    
}
