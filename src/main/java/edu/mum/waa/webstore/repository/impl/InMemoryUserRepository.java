/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.User;
import edu.mum.waa.webstore.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakesh Shrestha
 */
@Repository
public class InMemoryUserRepository implements UserRepository{
    
    Map<String, User> users;

    public InMemoryUserRepository() {
        users = new HashMap<String, User>();
        
        User rakesh = new User("dilip", "123");
        users.put(rakesh.getUserId(), rakesh);
    }
    
    @Override
    public User getByUserId(String userId) {
        return users.get(userId);
    }
    
}
