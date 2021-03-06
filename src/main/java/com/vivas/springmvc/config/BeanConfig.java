package com.vivas.springmvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by duyot on 8/23/2016.
 */
@Configuration
public class BeanConfig {

    Logger log = LoggerFactory.getLogger(BeanConfig.class);


    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    /*
        config profile in web.xml, param name: spring.profiles.default
     */
    @Bean
    @Primary
    @Profile(value = "dev")
    @Lazy
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@10.84.70.116:1521:DEVMKT");
        ds.setUsername("sms_ads");
        ds.setPassword("sms123");
        log.info("Getting datasource with dev profile");
        return ds;
    }

    @Bean
    @Profile(value = "prod")
    @Lazy
    public DataSource  initDataSourceFromJndi() {
//        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//        jndiObjectFB.setJndiName("jdbc/ConnectionPool");
//        jndiObjectFB.setResourceRef(true);
//        jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
//        log.info("Getting datasource with prod profile with jndi");
//        DataSource dataSource = (DataSource)jndiObjectFB.getObject();
//        return dataSource;
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/ConnectionPool");
        DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/ConnectionPool2");
        return dataSource;
    }

    /*
        Persistent
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[] { "com.vivas.springmvc.persistences.entity" });
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        props.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        sfb.setHibernateProperties(props);
        return sfb;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new HibernateTransactionManager(sessionFactory(dataSource()).getObject());
//    }
//    @Bean
//    public HibernateTemplate hibernateTemplate() {
//        return new HibernateTemplate(sessionFactory(dataSource()).getObject());
//    }
}
