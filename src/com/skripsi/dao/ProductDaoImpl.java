/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.dao;

import com.skripsi.connection.DBConnection;
import com.skripsi.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class ProductDaoImpl implements ProductDao{

    private Connection connection;
    
    public ProductDaoImpl(){
        connection = DBConnection.getConnection();
    }
    
    @Override
    public List<Product> getList() {
      List list = new ArrayList();
      ResultSet rs = null;
      String sql = "select * from product";
      PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setIdproduct(rs.getString("idproduct"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean saveProduct(Product product) {
        PreparedStatement statement=null;
        boolean valid=false;
        String sql = "INSERT INTO product(idproduct, name, quantity) "
                + "VALUES(?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, product.getIdproduct());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }
    
}
