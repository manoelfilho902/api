/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.controller;

import com.github.manoelfilho902.simple.spring.api.model.entity.User;
import com.github.manoelfilho902.simple.spring.api.service.JwtService;
import com.github.manoelfilho902.simple.spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    protected UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final System.Logger LOG = System.getLogger(UserController.class.getName());
  
    
    /**
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Validated LoginRequest loginRequest) {
      
        try {         
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.username,
                            loginRequest.password
                    )
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwtToken = jwtService.generateToken(userDetails);

            return ResponseEntity.ok(new AuthResponse(jwtToken, "Login realizado com sucesso"));

        } catch (AuthenticationException e) {
            LOG.log(System.Logger.Level.WARNING, e);
            return ResponseEntity.status(401).body(
                    new AuthResponse(null, "Credenciais inválidas")
            );
        }
    }
    // only for tests todo: create a database to run first time.
    @GetMapping("/admin")
    public void buidAdmin() {
        User user = new User("sysadmin@mail.com", passwordEncoder.encode("123456789#@!"));
        user.setFullname("System administrator");
        
        service.save(user);
    }

    @GetMapping()
    public void getUser() {

    }

    @PutMapping()
    public void save() {

    }

    // DTOs como records (Java 17+)
    public record LoginRequest(String username, String password) {

    }

    public record AuthResponse(String token, String message) {

    }
}
