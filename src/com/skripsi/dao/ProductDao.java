/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.dao;

import com.skripsi.entity.Product;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface ProductDao {
    
    List<Product> getList();
    
    boolean saveProduct(Product product);
}
