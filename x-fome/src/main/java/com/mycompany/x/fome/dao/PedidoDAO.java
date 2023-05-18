/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.dao;

import com.mycompany.x.fome.domain.Pedido;
import com.mycompany.x.fome.domain.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author prisc
 */
public class PedidoDAO {
    public Pedido inserir(Pedido pedido, List<Produto> produtos) throws HibernateException {        
        
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            //OPERAÇÕES
            sessao.save(pedido);
            ProdutoPedido produto
            sessao.getTransaction().commit();              
            sessao.close();
            
        } catch( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        
        return pedido;
    }
}
