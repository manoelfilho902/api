/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.model.entity;

import com.github.manoelfilho902.simple.spring.api.model.entity.common.EntityBase;
import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author mbatista
 * @description this entity has name users because in db has user as a preserved
 * word
 */
@Table(name = "users")
public class User extends EntityBase implements UserDetails {

    @Id()
    private Integer id;
    @Column("name")
    private String fullname;
    @Column("email")
    private String email;
    @Column("password")
    private String password;

    @MappedCollection(idColumn = "id_user")
    private UserProfile profiles;

    public User() {

    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @return Integer return the id
     */
    @Override
    public BigInteger getId() {
        return BigInteger.valueOf(id);
    }

    /**
     *
     * @return
     */
    public Integer getIdInteger() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles.getProfiles();
    }

    public void setProfiles(UserProfile profiles) {
        this.profiles = profiles;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
