/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 2021122760232
 */
public class ProdutoPedido {
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn (name = "idPedido")
    private Produto produto;
    
    private int qtd;
    private double preco;
}
