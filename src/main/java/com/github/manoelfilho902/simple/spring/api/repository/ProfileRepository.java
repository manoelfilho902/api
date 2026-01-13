/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.repository;

import com.github.manoelfilho902.simple.spring.api.model.entity.Profile;
import com.github.manoelfilho902.simple.spring.api.repository.common.RepositoryBase;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Repository
public interface ProfileRepository extends RepositoryBase<Profile, Integer>{
    
}
