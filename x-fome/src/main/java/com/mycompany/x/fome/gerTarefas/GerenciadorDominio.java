/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.gerTarefas;

import com.mycompany.x.fome.dao.ConexaoHibernate;
import com.mycompany.x.fome.dao.GenericDAO;
import com.mycompany.x.fome.dao.ProdutoDAO;
import com.mycompany.x.fome.dao.UsuarioDAO;
import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Pedido;
import com.mycompany.x.fome.domain.Produto;
import com.mycompany.x.fome.domain.ProdutoPedido;
import com.mycompany.x.fome.domain.Status;
import com.mycompany.x.fome.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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
   UsuarioDAO usuarioDAO = null;
   Usuario usuario = null;
   
   public GerenciadorDominio() throws HibernateException {
        // TESTE
        try{
            ConexaoHibernate.getSessionFactory();
            genDao = new GenericDAO();
            produtoDAO = new ProdutoDAO();
            usuarioDAO = new UsuarioDAO();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Deu erro" + ex.getMessage() );          
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
    
    //Pedido
   public void efetuarPedido(Vector pedidos, boolean isRetirarNaLoja) {
        if (pedidos != null) {
            for (Object obj : pedidos) {
                if (obj instanceof Vector) {
                    Vector produto = (Vector) obj;
                    JOptionPane.showMessageDialog(null, obj);
                    if (produto.size() >= 2) {
                        
                        Produto primeiroAtributo = (Produto) produto.get(0);
                        Integer qtd = (Integer) produto.get(1);
                        List<Status> statusList = genDao.listar(Status.class);
                        Status status = statusList.stream().filter(x -> x.getNome().equals("Pendente")).findFirst().get();
                        
                        Pedido pedido = new Pedido(usuario, status, new Date(), usuario.getEndereco(), isRetirarNaLoja, 2.2);
                        
                        ProdutoPedido produtoPedido = new ProdutoPedido();
                        }
                    }
                }
        }
    }
   
   public boolean efetuarLogin(String email, String senha){
       Usuario usuario = usuarioDAO.findByEmailAndSenha(email, senha);
       if(usuario != null){
           return true;
       }
       return false;
   }
}
