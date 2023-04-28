/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
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
public class Pedido {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPedido;
    private Usuario cliente;
    
    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;
    
    @Temporal ( TemporalType.DATE )
    private Date data;
    private String endereco;
    
    @OneToMany ( mappedBy = "produto", fetch =  FetchType.LAZY)
    private ArrayList<ProdutoPedido> produtos;
    
    
    private double taxa_entrega;
    
    
}
