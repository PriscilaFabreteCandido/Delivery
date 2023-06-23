/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain.strategy;

/**
 *
 * @author 2021122760232
 */
public class DescontoMeta200 implements DescontoStrategy{
    double desconto = 0.25;
    
    @Override
    public double calcularDesconto(Double total) {
        return (total * ( 1 - desconto));
    }
    
    @Override
    public String getDesconto() {
        return "25%";
    }
}
