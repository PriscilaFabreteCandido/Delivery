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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2021122760232
 */
public class DlgLoja extends javax.swing.JDialog {

    /**
     * Creates new form DlgLoja
     */
    
    private GerInterGrafica gerIG = null;
    private ArrayList<Produto> selectedProdutos = null;
    private String simNaoString= "Não";
    
    public DlgLoja(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG ) {
        super(parent, modal);
        initComponents();
        this.gerIG = gerIG;
        this.loadCombobox();
        
        this.totalCompra.setText("0");
        this.desconto.setText("0");
        total.setText("0");
    }
    
    public void loadCombobox(){
        this.gerIG.carregarComboCategoria(categoriaCombobox, Categoria.class);
        Categoria categoria = (Categoria) this.categoriaCombobox.getModel().getSelectedItem();
        if(categoria != null){
            this.gerIG.carregarListaProdutosPorCategoria(tabelaProdutoByCat, categoria);
        }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        simNao = new javax.swing.ButtonGroup();
        categoriaCombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        qtd = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        realizarPedido = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        desconto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SimNaoCombo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaProdutoByCat = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalCompra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        categoriaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoriaCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaComboboxActionPerformed(evt);
            }
        });
        categoriaCombobox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                categoriaComboboxPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Categoria: ");

        qtd.setValue(1);

        jLabel3.setText("Qtd: ");

        realizarPedido.setBackground(new java.awt.Color(255, 153, 153));
        realizarPedido.setText("Realizar Pedido");
        realizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarPedidoActionPerformed(evt);
            }
        });

        adicionar.setBackground(new java.awt.Color(153, 255, 153));
        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        excluir.setBackground(new java.awt.Color(255, 204, 204));
        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtos", "Qtd", "Total"
            }
        ));
        jScrollPane1.setViewportView(tableProdutos);

        jLabel6.setText("Desconto:");

        desconto.setBackground(new java.awt.Color(204, 0, 0));
        desconto.setText("20%");

        jLabel7.setText("jLabel7");

        jLabel4.setText("Taxa de Entrega: R$ 2,00");

        jLabel5.setText("Deseja retirar na loja?");

        SimNaoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        SimNaoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimNaoComboActionPerformed(evt);
            }
        });
        SimNaoCombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                SimNaoComboPropertyChange(evt);
            }
        });

        tabelaProdutoByCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Ingredientes", "Preço"
            }
        ));
        jScrollPane3.setViewportView(tabelaProdutoByCat);

        jLabel8.setText("Total:");

        total.setText("R$ 80,00");

        jLabel9.setText("Total da Compra: ");

        totalCompra.setText("R$ 100,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(categoriaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(excluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(adicionar)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(SimNaoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(133, 133, 133)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(desconto))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(total))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(totalCompra)))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(165, 165, 165)
                        .addComponent(realizarPedido)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categoriaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(adicionar)
                    .addComponent(excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(desconto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(SimNaoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(totalCompra)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(total))
                .addGap(23, 23, 23)
                .addComponent(realizarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed

        loadTableLoja(tableProdutos);
    }//GEN-LAST:event_adicionarActionPerformed

    private void categoriaComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaComboboxActionPerformed
       
        Categoria categoria = (Categoria) this.categoriaCombobox.getModel().getSelectedItem();
        this.gerIG.carregarListaProdutosPorCategoria(tabelaProdutoByCat, categoria);
    }//GEN-LAST:event_categoriaComboboxActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void categoriaComboboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_categoriaComboboxPropertyChange
       
    }//GEN-LAST:event_categoriaComboboxPropertyChange

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tableProdutos.getModel();
        
        if (tableProdutos.getSelectedRow() >= 0 && tableProdutos.getSelectedRow() <= this.selectedProdutos.size()){
            this.selectedProdutos.remove(tableProdutos.getSelectedRow());
            tableModel.removeRow(tableProdutos.getSelectedRow());
            tableProdutos.setModel(tableModel);
            this.desconto.setText(getTotal().toString());
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }

       
    }//GEN-LAST:event_excluirActionPerformed
    private void limparTudo(){
        DefaultTableModel tableModel = (DefaultTableModel) tableProdutos.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        tableModel.setRowCount(0);
        this.desconto.setText("R$ 0,00");
    }
    
    private void realizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarPedidoActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tableProdutos.getModel();
        if(this.SimNaoCombo.getSelectedItem().toString().equals("Não")){
           this.gerIG.getGerDominio().efetuarPedido(tableModel.getDataVector(), false); 
        }else{
           this.gerIG.getGerDominio().efetuarPedido(tableModel.getDataVector(), true); 
        }
        
        this.limparTudo();
    }//GEN-LAST:event_realizarPedidoActionPerformed

    private void SimNaoComboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_SimNaoComboPropertyChange
        
    }//GEN-LAST:event_SimNaoComboPropertyChange

    private void SimNaoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimNaoComboActionPerformed
        if(this.SimNaoCombo.getSelectedItem().toString().equals("Sim")){
           simNaoString = "Sim";
           this.desconto.setText(getTotal().toString());
        }
        else if(simNaoString.equals("Não")){
           simNaoString = "Não";
           this.desconto.setText(getTotal().toString());
        }
    }//GEN-LAST:event_SimNaoComboActionPerformed
    
    public void loadTableLoja(JTable tabela) {
        DefaultTableModel tableModel = (DefaultTableModel) tableProdutos.getModel();
        
        if(selectedProdutos == null){
            tableModel.setRowCount(0);
            selectedProdutos = new ArrayList<Produto>();
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableProdutos.setDefaultRenderer(Object.class, centerRenderer);

        int linha = this.tabelaProdutoByCat.getSelectedRow();
        if(linha >= 0){
            Produto p = (Produto) this.tabelaProdutoByCat.getValueAt(linha, 0);
            
            Double total = Double.parseDouble(qtd.getValue().toString()) * p.getPreco();
            Object[] rowData = {p, qtd.getValue(), total};
            this.selectedProdutos.add(p);
            tableModel.addRow(rowData);
            
            this.desconto.setText(getTotal().toString());
        }
        
        tabela.setShowVerticalLines(false);
    }
    
    public Double getTotal(){
        Double total = 0.0;

        DefaultTableModel tableModel = (DefaultTableModel) tableProdutos.getModel();
        if (tableModel.getDataVector() != null) {
            for (Object obj : tableModel.getDataVector()) {
                if (obj instanceof Vector) {
                    Vector item = (Vector) obj;

                    if (item.size() >= 2) {
                            Produto produto = (Produto) item.get(0);
                            Integer qtd = (Integer) item.get(1);
                            total += produto.getPreco() * qtd.doubleValue();
                        }
                    }
            }
        }
        
        if(simNaoString.equals("Não")){
            total += 2;
        }
        
        this.totalCompra.setText(total.toString());
        this.desconto.setText(this.gerIG.getGerDominio().getUsuario().getDescontoStrategy().getDesconto());
        return this.gerIG.getGerDominio().getUsuario().getDescontoStrategy().calcularDesconto(total);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SimNaoCombo;
    private javax.swing.JButton adicionar;
    private javax.swing.JComboBox<String> categoriaCombobox;
    private javax.swing.JLabel desconto;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner qtd;
    private javax.swing.JButton realizarPedido;
    private javax.swing.ButtonGroup simNao;
    private javax.swing.JTable tabelaProdutoByCat;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalCompra;
    // End of variables declaration//GEN-END:variables
}
