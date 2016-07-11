/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.Cart;
import edu.mum.waa.webstore.repository.CartRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakesh Shrestha
 */
@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> carts;

    public InMemoryCartRepository() {
        carts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) {
        if (carts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException(String.format(
                    "Can not create a cart. A cart with the given id (%) already exist.",
                    cart.getCartId()));
        }

        carts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return carts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart updatedCart) {
        if (!carts.containsKey(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot update the cart.The cart with the given id(%) does not exist",
           
                    cartId));
        }
        carts.put(cartId, updatedCart);
    }

    @Override
    public void delete(String cartId) {
        if(!carts.containsKey(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with the given id (%) does not exist", cartId));
        }
        carts.remove(cartId);
    }

}
