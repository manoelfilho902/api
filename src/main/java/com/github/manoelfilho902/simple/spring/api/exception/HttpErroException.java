/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author mbatista
 */
public class HttpErroException extends RuntimeException {

    private final HttpStatus status;

    public HttpErroException(String string, HttpStatus status) {
        super(string);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}