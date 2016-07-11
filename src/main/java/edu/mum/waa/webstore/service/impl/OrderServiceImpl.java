/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakesh Shrestha
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        Product orderdProduct = productRepository.getProductById(productId);

        if (orderdProduct != null) {
            if (quantity < orderdProduct.getUnitsInStock()) {
                orderdProduct.setUnitsInStock(
                        orderdProduct.getUnitsInStock() - quantity);
            } else {
                throw new IllegalArgumentException(String.format("Order quantity "
                        + "is greater than or equal to availabe quantity %d", 
                        orderdProduct.getUnitsInStock()));
            }
        }
    }

}
