/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.gerTarefas;

import com.mycompany.x.fome.dao.ConexaoHibernate;
import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Pedido;
import com.mycompany.x.fome.domain.Produto;
import com.mycompany.x.fome.domain.ProdutoPedido;
import com.mycompany.x.fome.domain.Status;
import com.mycompany.x.fome.domain.Usuario;
import com.mycompany.x.fome.view.DlgCadProduto;
import com.mycompany.x.fome.view.DlgGerenciarCatProd;
import com.mycompany.x.fome.view.DlgGerenciarProdutos;
import com.mycompany.x.fome.view.DlgLogin;
import com.mycompany.x.fome.view.DlgLoja;
import com.mycompany.x.fome.view.DlgPedido;
import com.mycompany.x.fome.view.DlgUsuario;
import com.mycompany.x.fome.view.DlgVisualizarPedidos;
import com.mycompany.x.fome.view.FormGerenciarPedidos;
import com.mycompany.x.fome.view.FormPrincipalCliente;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author 2021122760232
 */
public class GerInterGrafica {

    /**
     * @param args the command line arguments
     */
    
    private FormPrincipalCliente principalCliente = null;
    private DlgLogin dlgLogin = null;
    private DlgUsuario dlgUsuario = null;
    private DlgLoja dlgLoja = null;
    private DlgVisualizarPedidos dlgVisualizarPedidos = null;
    private FormGerenciarPedidos gerenciarPedidos = null;
    private DlgGerenciarProdutos dlgGerenciarProdutos = null;
    private DlgGerenciarCatProd dlgGerenciarCatProd = null;
    private DlgCadProduto dlgCadProduto = null;
    private DlgPedido dlgPedido = null;
    GerenciadorDominio gerDominio;
    
    public GerInterGrafica() {
        gerDominio = new GerenciadorDominio();
        ConexaoHibernate.getSessionFactory();
    }
    
    //singleton 
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe, boolean visible) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class ).newInstance(parent,visible, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            } 
        }        
        dlg.setVisible(true); 
        return dlg;
    }
    
    public GerenciadorDominio getGerDominio() {
        return gerDominio;
    }
    
    public void openJanelaPrincipalCliente(){
        principalCliente = new FormPrincipalCliente(this);
        principalCliente.setVisible(true);
    }
    
     public void openJanelaGerenciarPedidos(){
        gerenciarPedidos = new FormGerenciarPedidos(this);
        gerenciarPedidos.setVisible(true);
    }
    
    public void openJanelaUsuario(){
        dlgUsuario = (DlgUsuario) abrirJanela(null, dlgUsuario, DlgUsuario.class, true);
    }
    
    public void openJanelaLogin(){
        dlgLogin = (DlgLogin) abrirJanela(null, dlgLogin, DlgLogin.class, true);
        
    }
    
    public void openJanelaLoja(){
        dlgLoja = (DlgLoja) abrirJanela(principalCliente, dlgLoja, DlgLoja.class, true);
    }
    
    public void openJanelaGerenciarProdutos(){
        dlgGerenciarProdutos = (DlgGerenciarProdutos) abrirJanela(gerenciarPedidos, dlgGerenciarProdutos, DlgGerenciarProdutos.class, true);
    }
    
    public void openJanelaCadastrarProduto(Categoria categoria, Produto produto){
        
        dlgCadProduto = (DlgCadProduto) abrirJanela(gerenciarPedidos, dlgCadProduto, DlgCadProduto.class, false);
        dlgCadProduto.setCategoria(categoria);
        dlgCadProduto.setProduto(produto);
        dlgCadProduto.preencherCampos();
        dlgCadProduto.setVisible(true);

    }
    
    public void openJanelaVisualizarPedidos(){
        dlgVisualizarPedidos = (DlgVisualizarPedidos) abrirJanela(gerenciarPedidos, dlgVisualizarPedidos, DlgVisualizarPedidos.class, true);
    }
    public void openJanelaGerenciarCatProduto(){
        dlgGerenciarCatProd = (DlgGerenciarCatProd) abrirJanela(gerenciarPedidos, dlgGerenciarCatProd, DlgGerenciarCatProd.class, true);
    }
    
    public void atualizarTelas(){
        if(dlgGerenciarCatProd != null){
            try {
                dlgGerenciarCatProd.loadTable();
            } catch (ParseException ex) {
                Logger.getLogger(GerInterGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(dlgGerenciarProdutos != null){
            try {
                dlgGerenciarProdutos.loadTable();
            } catch (ParseException ex) {
                Logger.getLogger(GerInterGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(gerenciarPedidos != null){
            gerenciarPedidos.loadTable();
        }
    }
    public void openJanelaPedido(Pedido pedido){
        dlgPedido = (DlgPedido) abrirJanela(gerenciarPedidos, dlgPedido, DlgPedido.class, false);
        dlgPedido.setPedido(pedido);
        dlgPedido.setVisible(true);
    }
    
    public void carregarComboCategoria(JComboBox combo, Class classe) {

         try {
             List<Categoria> lista = gerDominio.listar(classe);
             combo.setModel( new DefaultComboBoxModel( lista.toArray() ));

         } catch (HibernateException  ex) {
             JOptionPane.showMessageDialog(principalCliente, "Erro ao carregar cidades. " + ex.getMessage() );          
         } 

    }
    
    public void carregarComboBox(JComboBox combo, Class classe) {

         try {
            
             combo.setModel( new DefaultComboBoxModel( gerDominio.listar(classe).toArray() ));

         } catch (HibernateException  ex) {
             JOptionPane.showMessageDialog(principalCliente, "Erro ao carregar cidades. " + ex.getMessage() );          
         } 

    }
   
    public void carregarListaProdutosPorCategoria(JTable tabela, Categoria categoria){
        try {
            List<Produto> lista = getGerDominio().findProdutosByCategoria(categoria);
            DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            tableModel.setRowCount(0);

            for(Produto produto : lista){
                Object[] rowData = {produto, produto.getIngredientes(), produto.getPreco()};
                tableModel.addRow(rowData);
            }
            
            tabela.setShowVerticalLines(false);
         } catch (HibernateException  ex) {
             JOptionPane.showMessageDialog(principalCliente, "Erro " + ex.getMessage() );          
         } 

    }
    
    public void loadTableVisualizarPedidos(JTable tabela){
        DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.setDefaultRenderer(Object.class, centerRenderer);
        tableModel.setRowCount(0);
        
        Usuario usuario = this.gerDominio.getAllPedidosByUser();

        if(!usuario.getPedidos().isEmpty() && usuario.getPedidos().size() > 0 ){
           
            Double total = 0.0;
            for(Pedido pedido : usuario.getPedidos()){
                StringBuilder produtos = new StringBuilder();
                String status = pedido.getStatus().getNome();
                total = 0.0;
                if(!pedido.isIsRetirarNaLoja()){
                    total = 2.0;
                }
                for(ProdutoPedido item: pedido.getProdutos()){
                    
                    total += item.getPreco() * item.getQtd();
                    int qtd = item.getQtd();
                    produtos.append(qtd + " - " + item.getProduto().getNomeProduto() + "; " );
                }
                
                Object[] rowData = {produtos.toString(), status, pedido.getTotal()};
                
                tableModel.addRow(rowData);
            }   
        }
        
        tabela.setShowVerticalLines(false);
    }
    
    
    
    public String converterData(Date dataString) {
        String dataFormatada = "";
        try {
            // Cria um objeto SimpleDateFormat para definir o formato desejado
            DateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            // Converte a data para uma string no formato de entrada
            String dataStringFormatada = formatoEntrada.format(dataString);

            // Converte a string formatada para um objeto Date
            Date data = formatoEntrada.parse(dataStringFormatada);

            // Formata a data no novo formato
            dataFormatada = formatoSaida.format(data);

            System.out.println("Data formatada: " + dataFormatada);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataFormatada;
    }
    
    public static void main(String[] args) {
        GerInterGrafica g = new GerInterGrafica();
        g.openJanelaLogin();
    }

    
    
}
