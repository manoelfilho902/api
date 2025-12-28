/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.manoelfilho902.simple.spring.api.configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

/**
 *
 * @author mbatista
 * @description buid data source repository
 */
@Configuration
@EnableJdbcRepositories
public class Dataset extends AbstractJdbcConfiguration{

    private static final System.Logger LOG = System.getLogger(Dataset.class.getName());
    /**
     * @description this is autoconfigurated by spring boot
     * @param url
     * @param user
     * @param pass
     * @return 
     */
    @Bean
    DataSource dataSource(@Value("${datasource.url}") String url, @Value("${datasource.username}") String user, @Value("${datasource.password}") String pass){
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername(user);
        ds.setPassword(pass);

        return ds;
    }
    /**
     * 
     * @param dataSource
     * @return 
     */
    @Bean
    NamedParameterJdbcOperations jdbcOperations(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
    /**
     * 
     * @param ds
     * @return 
     */
    @Bean
    TransactionManager manager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }

}
