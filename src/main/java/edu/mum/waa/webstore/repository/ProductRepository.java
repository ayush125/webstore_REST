/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository;

import edu.mum.waa.webstore.domain.Product;
import java.util.List;

/**
 *
 * @author Rakesh Shrestha
 */
public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    void addProduct (Product product);
    Product addNewProduct(Product product);
    void deleteProduct(String productId);
}
