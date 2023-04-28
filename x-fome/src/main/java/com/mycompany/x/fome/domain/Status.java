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
 * @author 2021122760232
 */
public class Status {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idStatus;
    
    @Column (name="senha", length = 250, nullable = false)
    private String status;
}
