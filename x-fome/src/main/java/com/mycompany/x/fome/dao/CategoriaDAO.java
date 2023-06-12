/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.dao;

import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Usuario;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 2021122760232
 */
public class CategoriaDAO {
    public Categoria findById(int idCategoria) {
    Session sessao = null;
    Categoria categoriaEncontrada = null;

    try {
        sessao = ConexaoHibernate.getSessionFactory().openSession();
        sessao.beginTransaction();

        CriteriaBuilder builder = sessao.getCriteriaBuilder();
        CriteriaQuery<Categoria> consulta = builder.createQuery(Categoria.class);
        Root<Categoria> root = consulta.from(Categoria.class);

        Predicate condicao = builder.equal(root.get("idCategoria"), idCategoria); // Corrigido o uso do método equal

        consulta.select(root).where(condicao);

        categoriaEncontrada = sessao.createQuery(consulta).uniqueResult();
        if (categoriaEncontrada != null) {
            categoriaEncontrada.getProdutos().size(); // Carregar a coleção de produtos
        }

        sessao.getTransaction().commit();
    } catch (HibernateException erro) {
        if (sessao != null) {
            sessao.getTransaction().rollback();
        }
        // Tratar ou registrar o erro de alguma forma
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }

    return categoriaEncontrada;
}

}
