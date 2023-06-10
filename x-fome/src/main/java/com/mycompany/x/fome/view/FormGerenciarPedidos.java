/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.x.fome.view;

import com.mycompany.x.fome.domain.Categoria;
import com.mycompany.x.fome.domain.Pedido;
import com.mycompany.x.fome.domain.Produto;
import com.mycompany.x.fome.domain.Status;
import com.mycompany.x.fome.gerTarefas.GerInterGrafica;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2021122760232
 */
public class FormGerenciarPedidos extends javax.swing.JFrame {

    /**
     * Creates new form FrameGerenciarPedidos
     */
    private GerInterGrafica gerG = null;
    public FormGerenciarPedidos(GerInterGrafica gerG) {
        initComponents();
        this.gerG = gerG;
        this.gerG.carregarComboBox(statusCombobox, Status.class);
        this.maisRecente.setSelected(true);
        this.nao.setSelected(true);
        this.loadTable(table);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dataGroup = new javax.swing.ButtonGroup();
        simNao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        filtrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        statusCombobox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        maisRecente = new javax.swing.JRadioButton();
        maisAntigo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cancelarPedido = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sim = new javax.swing.JRadioButton();
        nao = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadProd = new javax.swing.JMenu();
        menuGerProd = new javax.swing.JMenu();
        menuGerCatProd = new javax.swing.JMenu();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gerenciar Pedidos");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Pedido", "Status", "Endereco", "Cliente", "Data", "Taxa Entrega", "Entregar em Casa"
            }
        ));
        jScrollPane1.setViewportView(table);

        filtrar.setBackground(new java.awt.Color(204, 204, 255));
        filtrar.setText("Filtrar");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Status: ");

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Endereco:  ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        dataGroup.add(maisRecente);
        maisRecente.setText("Mais recentes");

        dataGroup.add(maisAntigo);
        maisAntigo.setText("Mais antigos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maisRecente)
                .addGap(18, 18, 18)
                .addComponent(maisAntigo)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maisRecente)
                    .addComponent(maisAntigo)))
        );

        jLabel5.setText("Cliente:");

        jLabel6.setText("Código");

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Editar Pedido");

        cancelarPedido.setBackground(new java.awt.Color(255, 204, 204));
        cancelarPedido.setText("Cancelar Pedido");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Retirar na Loja?"));

        simNao.add(sim);
        sim.setText("Sim");

        simNao.add(nao);
        nao.setText("Não");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sim)
                .addGap(18, 18, 18)
                .addComponent(nao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sim)
                    .addComponent(nao)))
        );

        menuCadProd.setText("Cadastrar Produto");
        menuCadProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCadProdMouseClicked(evt);
            }
        });
        menuCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProdActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuCadProd);

        menuGerProd.setText("Gerenciar Produtos");
        menuGerProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGerProdMouseClicked(evt);
            }
        });
        menuGerProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerProdActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuGerProd);

        menuGerCatProd.setText("Gerenciar Categoria de Produtos");
        menuGerCatProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGerCatProdMouseClicked(evt);
            }
        });
        menuGerCatProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerCatProdActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuGerCatProd);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(statusCombobox, 0, 346, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                            .addComponent(cliente))
                                        .addGap(29, 29, 29)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(filtrar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jButton2)
                        .addGap(55, 55, 55)
                        .addComponent(cancelarPedido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(cancelarPedido))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProdActionPerformed
        this.gerG.openJanelaCadastrarProduto();
    }//GEN-LAST:event_menuCadProdActionPerformed

    private void menuGerProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerProdActionPerformed
         this.gerG.openJanelaGerenciarProdutos();
    }//GEN-LAST:event_menuGerProdActionPerformed

    private void menuGerCatProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerCatProdActionPerformed
        this.gerG.openJanelaGerenciarCatProduto();
    }//GEN-LAST:event_menuGerCatProdActionPerformed

    private void menuCadProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadProdMouseClicked
        this.gerG.openJanelaCadastrarProduto();
    }//GEN-LAST:event_menuCadProdMouseClicked

    private void menuGerProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGerProdMouseClicked
        this.gerG.openJanelaGerenciarProdutos();
    }//GEN-LAST:event_menuGerProdMouseClicked

    private void menuGerCatProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGerCatProdMouseClicked
        this.gerG.openJanelaGerenciarCatProduto();
    }//GEN-LAST:event_menuGerCatProdMouseClicked

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        this.loadTable(table);
    }//GEN-LAST:event_filtrarActionPerformed

    public void loadTable(JTable tabela) {
        DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.setDefaultRenderer(Object.class, centerRenderer);
        tableModel.setRowCount(0);
        
        
        try {
            List<Pedido> lista = this.gerG.getGerDominio().filtrarPedidos((Status) this.statusCombobox.getModel().getSelectedItem(), endereco.getText(), cliente.getText(), codigo.getText(), !this.maisRecente.isSelected(), this.sim.isSelected());
            if(!lista.isEmpty()){
                for(Pedido ped: lista){
                    Object[] rowData = {ped, ped.getStatus().getNome(), ped.getEndereco(), ped.getCliente().getNomeUsuario(),
                    this.gerG.converterData(ped.getData()), ped.getTaxa_entrega(),
                    ped.isIsRetirarNaLoja() ? "Não" : "Sim" };
                    tableModel.addRow(rowData);
                }
            }   
        } catch (Exception ex) {
            Logger.getLogger(FormGerenciarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        tabela.setShowVerticalLines(false);
    }
    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarPedido;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField codigo;
    private javax.swing.ButtonGroup dataGroup;
    private javax.swing.JTextField endereco;
    private javax.swing.JButton filtrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maisAntigo;
    private javax.swing.JRadioButton maisRecente;
    private javax.swing.JMenu menuCadProd;
    private javax.swing.JMenu menuGerCatProd;
    private javax.swing.JMenu menuGerProd;
    private javax.swing.JRadioButton nao;
    private javax.swing.JRadioButton sim;
    private javax.swing.ButtonGroup simNao;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
