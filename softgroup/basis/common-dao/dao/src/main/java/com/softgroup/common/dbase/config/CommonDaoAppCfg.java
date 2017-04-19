package com.softgroup.common.dbase.config;

import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.dialect.DerbyTenSevenDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;


/**
 * Created by Admin on 23.05.2016.
 * Spring configuration for common-dao module
 */

@Configuration
@PropertySource({ "classpath:dao.properties" })
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages = "com.softgroup.common.dbase.dao",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@ComponentScan(basePackages = {"com.softgroup.common.dbase.service"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Configuration.class})
)
public class CommonDaoAppCfg {

    private static final String[] ENTITY_PACKAGES = {
            "com.softgroup.common.dbase.model"
    };
    @Autowired
    Environment env;


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException{
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);
        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public DataSource dataSource() throws ClassNotFoundException{
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriverClass(ClientDriver.class);
        dataSource.setDriverClass(((Class<Driver>) Class.forName(env.getProperty("db0.driver"))));
        dataSource.setUrl(env.getProperty("db0.url"));
        dataSource.setUsername(env.getProperty("db0.username"));
        dataSource.setPassword(env.getProperty("db0.password"));

        return dataSource;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() throws ClassNotFoundException{
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory( entityManagerFactory().getObject());

        return transactionManager;
    }
    private JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.DERBY);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(DerbyTenSevenDialect.class.getCanonicalName());
        return jpaVendorAdapter;
    }

    @Bean
    public SpringLiquibase liquibase() throws ClassNotFoundException{
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquiBase.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }



}