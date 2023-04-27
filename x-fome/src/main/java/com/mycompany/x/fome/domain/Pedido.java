/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 2021122760232
 */
public class Pedido {
    private int idPedido;
//    private Usuario cliente;
    private Status status;
    private Date data;
    private String endereco;
    private ArrayList<ProdutoPedido> produtos;
    private double taxa_entrega;
    
    
}
