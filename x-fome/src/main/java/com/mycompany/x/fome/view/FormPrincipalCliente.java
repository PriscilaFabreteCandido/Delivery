/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.view;

import com.mycompany.x.fome.gerTarefas.GerInterGrafica;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author prisc
 */
public class FormPrincipalCliente extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private GerInterGrafica gerInterfaceGrafica = null;
    public FormPrincipalCliente(GerInterGrafica gerInterfaceGrafica) {
        initComponents();
        gerInterfaceGrafica = gerInterfaceGrafica;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        loja = new javax.swing.JMenu();
        pedidos = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        confuguracoes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loja.setText("Loja");
        loja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lojaMouseClicked(evt);
            }
        });
        loja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lojaActionPerformed(evt);
            }
        });
        jMenuBar1.add(loja);

        pedidos.setText("Meus Pedidos");
        pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidosMouseClicked(evt);
            }
        });
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        jMenuBar1.add(pedidos);
        jMenuBar1.add(jMenu3);

        confuguracoes.setText("Minha Conta");
        confuguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confuguracoesMouseClicked(evt);
            }
        });
        confuguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confuguracoesActionPerformed(evt);
            }
        });
        jMenuBar1.add(confuguracoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lojaActionPerformed
        
    }//GEN-LAST:event_lojaActionPerformed

    private void lojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lojaMouseClicked
        
        this.gerInterfaceGrafica.openJanelaLoja();
    }//GEN-LAST:event_lojaMouseClicked

    private void confuguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confuguracoesActionPerformed
        this.gerInterfaceGrafica.openJanelaUsuario();
    }//GEN-LAST:event_confuguracoesActionPerformed

    private void pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidosMouseClicked
      this.gerInterfaceGrafica.openJanelaVisualizarPedidos();
    }//GEN-LAST:event_pedidosMouseClicked

    private void confuguracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confuguracoesMouseClicked
        this.gerInterfaceGrafica.openJanelaUsuario();
    }//GEN-LAST:event_confuguracoesMouseClicked

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        this.gerInterfaceGrafica.openJanelaVisualizarPedidos();
    }//GEN-LAST:event_pedidosActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu confuguracoes;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu loja;
    private javax.swing.JMenu pedidos;
    // End of variables declaration//GEN-END:variables
}
