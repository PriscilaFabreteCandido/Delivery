/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.domain;

import java.io.Serializable;
import java.text.ParseException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 2021122760232
 */
@Entity
public class Status implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idStatus;

    public Status() {
    }
    
    @Column (name="nome", length = 250, nullable = false)
    private String nome;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public Status(int idStatus, String nome) {
        this.idStatus = idStatus;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this};
    }
}
