/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.tabelmodel;

import com.skripsi.entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class DefaultTableModel extends javax.swing.table.DefaultTableModel{
    
    
    private List<Product> list = new ArrayList<>();
    
   
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0: return list.get(rowIndex).getIdproduct();
           case 1: return list.get(rowIndex).getName();
           case 2: return list.get(rowIndex).getQuantity();
           default:return null;
       }
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0: return "idproduct";
          case 1: return "name";
          case 2: return "quantity";
          default:return null;
      }
    }
    
    public void getListProduct(List<Product> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public void getInsertProduct(Product product){
        this.list.add(product);
        fireTableDataChanged();
    }
}
