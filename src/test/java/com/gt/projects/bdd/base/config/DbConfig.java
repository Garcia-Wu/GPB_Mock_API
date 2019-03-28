package com.gt.projects.bdd.base.config;

import com.gt.projects.bdd.base.BaseStep;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Scope("thread")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.gt.projects.**.repository")
public class DbConfig {
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Scope("thread")
    @Bean(name = "dateSource")
    protected DataSource getDataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder
//                .setType(EmbeddedDatabaseType.H2)
//                .build();
//        File backup = new File("~/h2/testdb");
//        File newName = new File("~/h2/testdb" + System.currentTimeMillis());
//        backup.renameTo(newName);
    
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/h2/testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
    
        return dataSource;
    }
    
    @Scope("thread")
    @Bean(name = "entityManagerFactory")
    protected LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("com.gt.projects.**.entity");
        entityManagerFactory.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManagerFactory.setDataSource(this.getDataSource());
        entityManagerFactory.setJpaPropertyMap(this.getJpaProperties());
        return entityManagerFactory;
    }
    
    @Scope("thread")
    @Bean(name = "jpaVendorAdapter")
    protected JpaVendorAdapter getJpaVendorAdapter() {
        AbstractJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }
    
    @Scope("thread")
    @Bean(name = "transactionManager")
    protected PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    
    @Scope("thread")
    @Bean(name = "exceptionTranslation")
    protected PersistenceExceptionTranslationPostProcessor getExceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    protected Map<String, String> getJpaProperties() {
        Map<String, String> jpaProperties = new HashMap<String, String>();
        // jpaProperties.put("hibernate.connection.charSet", "UTF-8");
        // jpaProperties.put("hibernate.connection.characterEncoding", "UTF-8");
        // jpaProperties.put("hibernate.connection.useUnicode", "true");
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, "true");
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, "false");
        jpaProperties.put("javax.persistence.lock.timeout", "2000");
        jpaProperties.put("spring.jpa.open-in-view", "true");
        jpaProperties.put("spring.jpa.properties.hibernate.enable_lazy_load_no_trans", "true");
        return jpaProperties;
    }
}
