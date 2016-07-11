/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service;

import edu.mum.waa.webstore.domain.Product;
import java.util.List;

/**
 *
 * @author Rakesh Shrestha
 */
public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(String productId);
    public void addProduct(Product product);
    public Product addNewProduct(Product product);
    void deleteProductById(String productId);
    void updateProduct(String productId, Product product);
}
