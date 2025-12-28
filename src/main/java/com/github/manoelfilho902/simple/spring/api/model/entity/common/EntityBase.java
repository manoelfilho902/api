/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.model.entity.common;

import com.github.manoelfilho902.simple.spring.api.exception.MethodNotImplemented;
import java.math.BigInteger;

/**
 *
 * @author mbatista
 * to mark any entity
 */
public abstract  class EntityBase {
    public BigInteger getId(){
        throw new MethodNotImplemented();
    }
}
