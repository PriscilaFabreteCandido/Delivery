/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.dao;

import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 2021122760232
 */
public class ProdutoDAO {
    
    public List<Produto> getAllProdutosByCategoria(Categoria categoria) throws HibernateException {        
        
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            //OPERAÇÕES
            sessao.save(obj);

            sessao.getTransaction().commit();              
            sessao.close();
        } catch( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
    }
    
}
