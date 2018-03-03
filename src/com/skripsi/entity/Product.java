/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.entity;

/**
 *
 * @author dickajava
 */
public class Product {
    
    private String idproduct;
    private String name;
    private int quantity;

    public Product(String idproduct, String name, int quantity) {
        this.idproduct = idproduct;
        this.name = name;
        this.quantity = quantity;
    }

    public Product(){
        
    }
    
    public String getIdproduct(){
        return idproduct;
    }
    
    public void setIdproduct(String idproduct){
        this.idproduct = idproduct;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
