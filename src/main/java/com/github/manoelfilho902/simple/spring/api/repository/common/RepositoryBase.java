package com.github.manoelfilho902.simple.spring.api.repository.common;

import com.github.manoelfilho902.simple.spring.api.model.entity.common.EntityBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author mbatista
 * @param <T> etity obsject type
 * @param <ID> etitity id object type
 */
@NoRepositoryBean
public interface RepositoryBase<T extends EntityBase, ID extends Object> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>, CrudRepository<T, ID> {

}