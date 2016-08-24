package com.vivas.wiringbean.java;

import com.vivas.wiringbean.auto.Billboard;
import com.vivas.wiringbean.auto.CDPlayer;
import com.vivas.wiringbean.auto.CompactDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * Created by duyot on 8/11/2016.
 */
//@Configuration
//@PropertySource("config.properties")
public class Config {
    @Autowired
    Environment env;

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("oracle.jdbc.OracleDriver");
//        ds.setUrl("jdbc:oracle:thin:@10.84.70.116:1521:DEVMKT");
//        ds.setUsername("sms_ads");
//        ds.setPassword("sms123");
//        return ds;
//    }

//    @Bean()
//    public DataSource dataSource() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("jdbc/ConnectionPool");
//        return dataSource;
//    }


//    @Bean(destroyMethod="shutdown")
//    @Profile("prod2")
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }

//    @Bean
//    public DataSource getDataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean =
//                new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource) jndiObjectFactoryBean.getObject();
//    }

//    @Bean
//    public CompactDisk billboard(){
//        return new Billboard(env.getProperty("title"),env.getProperty("artist"));
//    }

//    @Bean
//    public CDPlayer cdPlayer(CompactDisk compactDisk){
//        return new CDPlayer(compactDisk);
//    }

}
