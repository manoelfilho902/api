/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.model.entity;

import com.github.manoelfilho902.simple.spring.api.model.entity.common.EntityBase;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Table(name = "user_profile")
public class UserProfile extends EntityBase {
    @Id
    @Column("id_user")
    private Integer idUser;
    @Column("id_profile")
    private Integer idProfile;

    public UserProfile() {
    }

    public UserProfile(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }   

}
