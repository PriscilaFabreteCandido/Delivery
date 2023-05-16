/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.gerTarefas;

import com.mycompany.x.fome.dao.ConexaoHibernate;
import com.mycompany.x.fome.dao.GenericDAO;
import com.mycompany.x.fome.dao.ProdutoDAO;
import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Produto;
import com.mycompany.x.fome.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author 2021122760232
 */
public class GerenciadorDominio {
    
   GenericDAO genDao = null;
   ProdutoDAO produtoDAO = null;
   public GerenciadorDominio() throws HibernateException {
        // TESTE
        try{
            ConexaoHibernate.getSessionFactory();
            genDao = new GenericDAO();
            produtoDAO = new ProdutoDAO();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Deuu erro" + ex.getMessage() );          
        }
    }
    
    // GENÉRICOS
    public List listar(Class classe) throws HibernateException {        
        return genDao.listar(classe);        
    }
    
    public void insertUsuario(String nomeUsuario, String endereco, String cep, boolean isCliente, String email, String senha, String cidade, String cpf){
        Usuario insertUsuario = new Usuario(nomeUsuario, endereco, cep, isCliente, email, senha, cidade, cpf);
        genDao.inserir(insertUsuario);
    }
    
    // GENÉRICOS
    public void excluir (Object obj) throws HibernateException {
        genDao.excluir(obj);
    }
    
    //Produto
    public List<Produto> findProdutosByCategoria(Categoria categoria){
        return produtoDAO.findProdutosByCategoria(categoria);
    }
}
