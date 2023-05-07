/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.gerTarefas;

import com.mycompany.x.fome.dao.ConexaoHibernate;
import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Usuario;
import com.mycompany.x.fome.view.DlgLogin;
import com.mycompany.x.fome.view.DlgLoja;
import com.mycompany.x.fome.view.DlgUsuario;
import com.mycompany.x.fome.view.DlgVisualizarPedidos;
import com.mycompany.x.fome.view.FormPrincipalCliente;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
    private GerenciadorDominio gerDominio;
    
    public GerInterGrafica() {
        ConexaoHibernate.getSessionFactory();
    }
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class ).newInstance(parent,true,this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            } 
        }        
        dlg.setVisible(true); 
        return dlg;
    }
    
 
    public void openJanelaPrincipalCliente(){
        principalCliente = new FormPrincipalCliente();
        principalCliente.setVisible(true);
    }
    
    public void openJanelaUsuario(){
        dlgUsuario = (DlgUsuario) abrirJanela(null, dlgUsuario, DlgUsuario.class);
    }
    
    public void openJanelaLogin(){
        dlgLogin = (DlgLogin) abrirJanela(null, dlgLogin, DlgLogin.class);
        
    }
    
    public void openJanelaLoja(){
        dlgLoja = (DlgLoja) abrirJanela(principalCliente, dlgLoja, DlgLoja.class);
    }
    
    public void openJanelaVisualizarPedidos(){
        dlgVisualizarPedidos = (DlgVisualizarPedidos) abrirJanela(principalCliente, dlgVisualizarPedidos, DlgVisualizarPedidos.class);
    }
   
    public void createUsuario(Usuario usuario){
        
    }
    
    public void carregarComboCategoria(JComboBox combo) {
        
        try {
            List<Categoria> lista = gerDominio.findAllCategoria();
            combo.setModel( new DefaultComboBoxModel( lista.toArray() )  );
                                   
        } catch (Exception  ex) {
            JOptionPane.showMessageDialog(principalCliente, "Erro ao carregar categorias " + ex.getMessage() );          
        } 
        
        
    }
    
    public static void main(String[] args) {
        GerInterGrafica g = new GerInterGrafica();
        g.openJanelaLogin();
    }
    
    
    
    
}
