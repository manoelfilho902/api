/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.model.entity;

import com.github.manoelfilho902.simple.spring.api.model.entity.common.EntityBase;
import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Table("profile")
public class Profile extends EntityBase implements GrantedAuthority{

    @Id
    private Integer id;
    @Column()
    private String name;
    @Column()
    private String description;

    public Profile(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profile() {
    }

    @Override
    public BigInteger getId() {
        return BigInteger.valueOf(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
       return name;
    }

}
