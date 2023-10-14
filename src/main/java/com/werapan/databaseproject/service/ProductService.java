/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.service;

import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class ProductService {
    ProductDao productDao = new ProductDao();
    public ArrayList<Product> getProductsOrderByname(){
        return (ArrayList<Product>) productDao.getAll(" product_name asc");
    }

    public Product addNew(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.save(editedProduct);
    }

    public Product update(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.update(editedProduct);
    }

    public int delete(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.delete(editedProduct);
    }
}
