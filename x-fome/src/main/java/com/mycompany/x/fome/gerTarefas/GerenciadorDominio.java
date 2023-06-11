/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.gerTarefas;

import com.mycompany.x.fome.dao.ConexaoHibernate;
import com.mycompany.x.fome.dao.GenericDAO;
import com.mycompany.x.fome.dao.PedidoDAO;
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
   PedidoDAO pedidoDAO = null;

    public GenericDAO getGenDao() {
        return genDao;
    }
   
   public GerenciadorDominio() throws HibernateException {
        // TESTE
        try{
            ConexaoHibernate.getSessionFactory();
            genDao = new GenericDAO();
            produtoDAO = new ProdutoDAO();
            usuarioDAO = new UsuarioDAO();
            pedidoDAO = new PedidoDAO();  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Deu erro" + ex.getMessage() );          
        }
    }
    
    // GENÉRICOS
    public List listar(Class classe) throws HibernateException {        
        return genDao.listar(classe);        
    }
    
    public Usuario insertUsuario(String nomeUsuario, String endereco, String cep, boolean isCliente, String email, String senha, String cidade, String cpf){
        Usuario insertUsuario = new Usuario(nomeUsuario, endereco, cep, isCliente, email, senha, cidade, cpf);
        genDao.inserir(insertUsuario);
        return insertUsuario;
    }
    
    public void editarUsuario(int idUsuario, String nomeUsuario, String endereco, String cep, boolean isCliente, String email, String senha, String cidade, String cpf){
        Usuario updateUser = new Usuario(nomeUsuario, endereco, cep, isCliente, email, senha, cidade, cpf);
        updateUser.setIdUsuario(idUsuario);
        genDao.alterar(updateUser);
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
       Pedido pedido = null;
       List<Produto> produtoList = new ArrayList<>();
        if (pedidos != null) {
            for (Object obj : pedidos) {
                if (obj instanceof Vector) {
                    Vector item = (Vector) obj;

                    if (item.size() >= 2) {
                            Produto produto = (Produto) item.get(0);
                            Integer qtd = (Integer) item.get(1);

                            List<Status> statusList = genDao.listar(Status.class);
                            Status status = statusList.stream().filter(x -> x.getNome().equals("Pendente")).findFirst().get();
                            
                            if(pedido == null){
                                pedido = new Pedido(usuario, status, new Date(), usuario.getEndereco(), isRetirarNaLoja, 2.2);
                                pedido.getProdutos().add(this.createProdutoPedido(pedido, produto, qtd));
                            }else{
                                pedido.getProdutos().add(this.createProdutoPedido(pedido, produto, qtd));
                            }
                        }
                    }
            }
        }
        pedido = this.pedidoDAO.inserir(pedido);
        JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!!");  
    }
   
   public ProdutoPedido createProdutoPedido(Pedido pedido, Produto produto, int qtd){
        ProdutoPedido produtoPedido = new ProdutoPedido();
        produtoPedido.setPedido(pedido);
        produtoPedido.setProduto(produto);
        produtoPedido.setPreco(produto.getPreco());
        produtoPedido.setQtd(qtd);
        return produtoPedido;
   }
   
   public Usuario efetuarLogin(String email, String senha){
       this.usuario = usuarioDAO.findByEmailAndSenha(email, senha);
       
       if(usuario != null){
           return this.usuario;
       }
       return null;
   }
   
   public Usuario getAllPedidosByUser(){
       this.usuario = usuarioDAO.getById(usuario, true);
       return usuario;
   }
   
   public void createCategoria(String nome){
       Categoria cat = new Categoria(nome);
       this.genDao.inserir(cat);
   }

    public Usuario getUsuario() {
        return usuario;
    }
   
    public void createProduto(Categoria cat, String nome, String ingredientes, Double preco){
        Produto prod = new Produto(cat, nome, ingredientes, preco);
        this.genDao.inserir(prod);
    }
   
    public List<Categoria> getAllCategoria(){
        return this.genDao.listar(Categoria.class);
    }
    
    public List<Pedido> filtrarPedidos(Status status, String endereco, String cliente, String codigo, boolean isMaisAntigo, boolean retirarLoja){
        return pedidoDAO.filtrar(status, endereco, cliente , 
                !codigo.isEmpty() ? Integer.parseInt(codigo) : 0, isMaisAntigo, retirarLoja);
    }
    
    public List<Produto> getAllProdutos(){
       return this.genDao.listar(Produto.class);
    }
    
    public void editarPedido(Pedido pedido){
        Pedido edit = new Pedido();
        edit.setCliente(pedido.getCliente());
        edit.setIdPedido(pedido.getIdPedido());
        edit.setStatus(pedido.getStatus());
        edit.setEndereco(pedido.getEndereco());
        edit.setData(pedido.getData());
        edit.setIsRetirarNaLoja(pedido.isIsRetirarNaLoja());

        this.genDao.alterar(edit);
    }
}
