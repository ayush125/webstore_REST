/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Dilip
 */
@Controller
@RequestMapping("rest/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }
    
    @RequestMapping(value="/{productId}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProductById(@PathVariable (value="productId") String productId){
        return productService.getProductById(productId);
    }
    
    @RequestMapping(value="/{productId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void deleteProductById(@PathVariable (value="productId") String productId){
        productService.deleteProductById(productId);
    }
    @RequestMapping(value="/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void updateProduct(@PathVariable (value="productId") String productId, @RequestBody Product product){
        productService.updateProduct(productId, product);
    }
}
