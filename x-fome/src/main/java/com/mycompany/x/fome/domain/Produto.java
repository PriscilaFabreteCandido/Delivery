/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author prisc
 */
public class Produto {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idProduto;
    
    private Categoria categoria;
    
    @Column (name="nomeProduto", length = 250, nullable = false)
    private String nomeProduto;
    
    @Column (name="ingredientes", length = 250, nullable = false)
    private String ingredientes;
    
    
    private Double preco;

  
    
    
}
