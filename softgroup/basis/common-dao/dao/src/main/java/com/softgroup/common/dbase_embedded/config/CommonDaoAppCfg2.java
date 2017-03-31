package com.softgroup.common.dbase_embedded.config;

import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.dialect.DerbyTenSevenDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by Admin on 23.05.2016.
 * Spring configuration for common-dao module
 */

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages = "com.softgroup.common.dbase_embedded.dao",
        entityManagerFactoryRef = "entityManagerFactory_Embedded",
        transactionManagerRef = "transactionManager_Embedded"
)
@ComponentScan(basePackages = {"com.softgroup.common.dbase_embedded.service"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Configuration.class})
)
public class CommonDaoAppCfg2 {

    private static final String[] ENTITY_PACKAGES = {
            "com.softgroup.common.dbase_embedded.model"
    };
    @Autowired
    Environment env;


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory_Embedded() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource_Embedded());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter_Embedded());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);
        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public DataSource dataSource_Embedded(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = builder
                .setType(EmbeddedDatabaseType.DERBY)
                .build();
        return embeddedDatabase;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager_Embedded(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory_Embedded().getObject());
        return transactionManager;
    }
    private JpaVendorAdapter jpaVendorAdapter_Embedded(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.DERBY);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(DerbyTenSevenDialect.class.getCanonicalName());
        return jpaVendorAdapter;
    }

    @Bean
    public SpringLiquibase liquibase_Embedded() throws ClassNotFoundException{
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquiBase_embedded.xml");
        liquibase.setDataSource(dataSource_Embedded());
        return liquibase;
    }


}