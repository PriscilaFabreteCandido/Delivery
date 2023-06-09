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
public class UsuarioDAO {
   public Usuario findByEmailAndSenha(String email, String senha) {
        Session sessao = null;
        Usuario usuarioEncontrado = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> consulta = builder.createQuery(Usuario.class);
            Root<Usuario> root = consulta.from(Usuario.class);

            Predicate condicao = builder.and(
                builder.equal(root.get("email"), email),
                builder.equal(root.get("senha"), senha)
            );

            consulta.select(root).where(condicao);

            usuarioEncontrado = sessao.createQuery(consulta).uniqueResult();
            
            for(Pedido pedido: usuarioEncontrado.getPedidos()){
                    pedido.getStatus();
                    for(ProdutoPedido item: pedido.getProdutos()){
                        item.getProduto();
                    }
            }
            
            sessao.getTransaction().commit();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return usuarioEncontrado;
    }
   
   
    public Usuario getById(Usuario user, boolean lazy) throws HibernateException {        
        Session sessao = null;
        Usuario usuarioEncontrado = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> consulta = builder.createQuery(Usuario.class);
            Root<Usuario> root = consulta.from(Usuario.class);

            Predicate condicao = builder.and(
                builder.equal(root.get("idUsuario"), user.getIdUsuario())
            );

            consulta.select(root).where(condicao);

            usuarioEncontrado = sessao.createQuery(consulta).uniqueResult();
            if(usuarioEncontrado != null && !lazy && usuarioEncontrado.getPedidos() != null){
                for(Pedido pedido: usuarioEncontrado.getPedidos()){
                    pedido.getStatus();
                    for(ProdutoPedido item: pedido.getProdutos()){
                        item.getProduto();
                    }
                }
            }
            
        } catch( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        
        return usuarioEncontrado;
    }
}
