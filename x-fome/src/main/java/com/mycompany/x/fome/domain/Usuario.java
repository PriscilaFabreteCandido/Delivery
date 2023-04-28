/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 2021122760232
 */
public class Usuario {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column (name="nomeUsuario", length = 250, nullable = false)
    private String nomeUsuario;
    
    @Column (name="endereco", length = 250, nullable = false)
    private String endereco;
    
    @Temporal ( TemporalType.DATE )
    private Date idade;
    
    @Column (name="cep", length = 250, nullable = false)
    private String cep;
    
    @Column (name="isCliente", nullable = false)
    private boolean isCliente;
    
    @Column (name="email", length = 250, nullable = false)
    private String email;
    
    @Column (name="senha", length = 250, nullable = false)
    private String senha;
     
    @Column (name="cidade", length = 250, nullable = false)
    private String cidade;
}
