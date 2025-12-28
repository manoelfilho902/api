/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.service.common;

import com.github.manoelfilho902.simple.spring.api.model.entity.User;
import com.github.manoelfilho902.simple.spring.api.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Service
public class UserService {
    @Autowired
    protected UserRepository repository;
    /**
     * 
     * @param user a valid user to save. 
     */
    public void save(@Validated User user){
        repository.save(user);
    }
    /**
     * 
     * @param user
     * @return a optional user object 
     */
    public Optional<User> get(User user){
        return repository.findOne(Example.of(user));
    }
}
