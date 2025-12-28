/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.controller;

import com.github.manoelfilho902.simple.spring.api.service.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Controller("login")
public class UserController {
    @Autowired
    protected UserService service;
    
    @GetMapping()
    public void getUser(){
        
    }
    @PostMapping("login")
    public void login(){
        
    }
    @PutMapping()
    public void save(){
        
    }
}
