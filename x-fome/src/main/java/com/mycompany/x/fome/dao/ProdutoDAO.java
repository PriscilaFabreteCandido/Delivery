/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.dao;

import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Produto;
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
 * @author 2021122760232
 */
public class ProdutoDAO {
    
    public List<Produto> findProdutosByCategoria(Categoria categoria) throws HibernateException {
       Session sessao = null;
       List<Produto> lista = null;

       try {
           sessao = ConexaoHibernate.getSessionFactory().openSession();
           sessao.beginTransaction();

           // OPERAÇÕES
           CriteriaBuilder builder = sessao.getCriteriaBuilder();
           CriteriaQuery<Produto> consulta = builder.createQuery(Produto.class);
           Root<Produto> root = consulta.from(Produto.class);

           // Faz o join com a propriedade "categoria" da classe passada como parâmetro
           Join<Produto, Categoria> joinCategoria = root.join("categoria");
           Predicate condicao = builder.equal(joinCategoria.get("idCategoria"), categoria.getIdCategoria());
           joinCategoria.on(condicao);

           consulta.select(root);
           lista = sessao.createQuery(consulta).getResultList();            

           sessao.getTransaction().commit();              
           sessao.close();
       } catch (HibernateException erro) {
           if (sessao != null) {
               sessao.getTransaction().rollback();
               sessao.close();
           }
       }

       return lista;
   }


    
}
