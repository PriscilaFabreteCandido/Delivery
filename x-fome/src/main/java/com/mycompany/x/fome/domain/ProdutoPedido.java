/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 2021122760232
 */
public class ProdutoPedido {
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn (name = "idProduto")
    private Produto produto;
    
    @Column (name="qtd", nullable = false)
    private int qtd;
    
    @Column (name="preco", nullable = false)
    private double preco;
}
