/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakesh Shrestha
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> listOfProduct;

    public InMemoryProductRepository() {
        listOfProduct = new ArrayList<>();

        Product iPhone = new Product("P1234", "iPhone", BigDecimal.valueOf(499));
        iPhone.setDescription("iPhone 7");
        iPhone.setCategory("Smart Phone");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(100);

        Product nexus7 = new Product("P1235", "Nexus 7", BigDecimal.valueOf(350));
        nexus7.setDescription("Nexus 7 tablet");
        nexus7.setCategory("Tablet");
        nexus7.setManufacturer("Asus");
        nexus7.setUnitsInStock(500);

        Product dellLatitude = new Product("P1236", "Dell Latitude", BigDecimal.valueOf(700));
        dellLatitude.setDescription("Dell latitude laptop");
        dellLatitude.setCategory("Laptop");
        dellLatitude.setManufacturer("Dell");
        dellLatitude.setUnitsInStock(50);

        listOfProduct.add(iPhone);
        listOfProduct.add(nexus7);
        listOfProduct.add(dellLatitude);

    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProduct;
    }

    @Override
    public Product getProductById(String productId) {
        for(Product product: listOfProduct){
            if(product.getProductId().equals(productId)) {
                return product;
            } 
        }
        throw new IllegalArgumentException(
                String.format("Product with id %s not found", productId));
    }

    @Override
    public void addProduct(Product product) {
        this.listOfProduct.add(product);
    }

    @Override
    public Product addNewProduct(Product product) {
        this.listOfProduct.add(product);
        return product;
    }

    @Override
    public void deleteProduct(String productId) {
        this.listOfProduct.remove(this.getProductById(productId));
    }
}
