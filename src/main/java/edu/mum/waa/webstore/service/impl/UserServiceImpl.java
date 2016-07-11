/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.User;
import edu.mum.waa.webstore.repository.UserRepository;
import edu.mum.waa.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakesh Shrestha
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;


    @Override
    public boolean authenticate(User user) {
        User userWithMatchingId = userRepository.getByUserId(user.getUserId());
        if(userWithMatchingId != null)
            return userWithMatchingId.getPassword().equals(user.getPassword());
        return false;
    }
    
}
