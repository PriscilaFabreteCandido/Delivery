/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.dao;

import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Pedido;
import com.mycompany.x.fome.domain.Produto;
import com.mycompany.x.fome.domain.ProdutoPedido;
import com.mycompany.x.fome.domain.Status;
import com.mycompany.x.fome.domain.Usuario;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author prisc
 */
public class PedidoDAO {
    public Pedido inserir(Pedido pedido) throws HibernateException {        
        
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            //OPERAÇÕES
            sessao.save(pedido);
            pedido.getIdPedido();
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
    
    public List<Pedido> filtrar(Status status, String endereco, String cliente, int codigo, boolean isMaisAntigo, boolean isRetirarNaLoja) {
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        CriteriaBuilder builder = sessao.getCriteriaBuilder();
        CriteriaQuery<Pedido> criteriaQuery = builder.createQuery(Pedido.class);
        Root<Pedido> root = criteriaQuery.from(Pedido.class);
        
        
        Predicate predicate = builder.conjunction(); // Inicia com um predicado de conjunção (AND)

        // Filtrar por status
        if (status != null) {
            predicate = builder.and(predicate, builder.equal(root.get("status"), status));
        }

        // Filtrar por endereço
        if (endereco != null && !endereco.isEmpty()) {
            predicate = builder.and(predicate, builder.like(root.get("endereco"), "%" + endereco + "%"));
        }
        
        // Filtrar por cliente
        if (cliente != null && !cliente.isEmpty()) {
            Join<Pedido, Usuario> joinCategoria = root.join("cliente");
            Predicate condicao = builder.like(joinCategoria.get("nomeUsuario"), "%" + cliente + "%");
            joinCategoria.on(condicao);
            predicate = builder.and(predicate, condicao);
        }

        // Filtrar por código
        if (codigo > 0) {
            predicate = builder.and(predicate, builder.equal(root.get("idPedido"), codigo));
        }
        
        // Filtrar por isRetirarNaLoja
        predicate = builder.and(predicate, builder.equal(root.get("isRetirarNaLoja"), isRetirarNaLoja));
        
        criteriaQuery.select(root)
                .where(predicate)
                .orderBy(isMaisAntigo ? builder.asc(root.get("data")) : builder.desc(root.get("data")));

        return sessao.createQuery(criteriaQuery).getResultList();
    }

}
