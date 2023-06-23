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
public interface DescontoStrategy {
    double calcularDesconto(Double total);
    String getDesconto();
}
