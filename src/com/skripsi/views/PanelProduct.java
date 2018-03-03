/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.views;

import com.skripsi.dao.ProductDaoImpl;
import com.skripsi.entity.Product;
import com.skripsi.tabelmodel.TabelModelProduct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dickajava
 */
public class PanelProduct extends javax.swing.JPanel {

    private TabelModelProduct tabelModelProduct;
    DefaultTableModel importFile;
    private ProductDaoImpl productDaoImpl;

    public PanelProduct() {
        initComponents();
        productDaoImpl = new ProductDaoImpl();
        importFile = new DefaultTableModel();
        tabelModelProduct = new TabelModelProduct();
        loadData();
    }

    private void loadData() {
        List<Product> productImport = productDaoImpl.getList();
        tabel_export.setModel(tabelModelProduct);
        tabelModelProduct.getListProduct(productImport);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_export = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_import = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Data Product");
        jPanel1.add(jLabel1);

        jScrollPane1.setViewportView(tabel_export);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExport.setText("Export to excel");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel2.add(btnExport);

        btnImport.setText("Import to excel");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jPanel2.add(btnImport);

        btnSave.setText("Save Import ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        jButton1.setText("Refresh Data Training");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        tabel_import.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idproduct", "name", "quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabel_import);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // export file to excel
        String filePath = "//home//dickajava//NetBeansProjects//c-45//data.xlsx";
        if (tabel_export.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "maaf tidak ada data training");
        } else {
            File file = new File(filePath);
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < tabel_export.getRowCount(); i++) {//rows

                    for (int j = 0; j < tabel_export.getColumnCount(); j++) {//columnt
                        bw.write(tabel_export.getValueAt(i, j).toString() + "\t");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(null, "data berhasil di export ke excel");
            } catch (IOException ex) {
                Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        chooser.setDialogTitle("Pilih untuk import data training");
        if (result == JFileChooser.APPROVE_OPTION) {

            String locationPath = chooser.getSelectedFile().getAbsolutePath();
            File file = new File(locationPath);
            if (!file.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, "Maaf ini bukan file excel !");
            } else {

                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);

                    importFile = (DefaultTableModel) tabel_import.getModel();
                    Object[] lines = br.lines().toArray();

                    for (int i = 0; i < lines.length; i++) {
                        String[] row = lines[i].toString().split("\t");
                        importFile.addRow(row);
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_btnImportActionPerformed

    
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // save
        if (importFile.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "maaf tabel data training masih kosong !");
        } else {
            List<Product> productList = new ArrayList<>();
            for (int i = 0; i < importFile.getRowCount(); i++) {
                Product product = new Product();
                String idproduct = (String) tabel_import.getValueAt(i, 0);
                String name = (String) tabel_import.getValueAt(i, 1);
                String quantity = (String) tabel_import.getValueAt(i, 2);

                product.setIdproduct(idproduct);
                product.setName(name);
                product.setQuantity(Integer.valueOf(quantity));
                productList.add(product);
                productDaoImpl.saveProduct(product);
                loadData();

            }
            //clear table import
            JOptionPane.showMessageDialog(null, "data berhasil disimpan !");
            if(importFile.getRowCount() > 0){
                for(int i = importFile.getRowCount() -1; i > -1; i--){
                    importFile.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadData();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_export;
    private javax.swing.JTable tabel_import;
    // End of variables declaration//GEN-END:variables
}
