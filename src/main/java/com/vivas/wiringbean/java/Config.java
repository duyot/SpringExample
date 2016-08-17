package com.vivas.wiringbean.java;

import com.vivas.wiringbean.auto.Billboard;
import com.vivas.wiringbean.auto.CDPlayer;
import com.vivas.wiringbean.auto.CompactDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * Created by duyot on 8/11/2016.
 */
@Configuration
@PropertySource("config.properties")
public class Config {
    @Autowired
    Environment env;


    @Bean(destroyMethod="shutdown")
    @Profile("prod2")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

    @Bean
    public DataSource getDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean =
                new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

//    @Bean
//    public CompactDisk billboard(){
//        return new Billboard(env.getProperty("title"),env.getProperty("artist"));
//    }

//    @Bean
//    public CDPlayer cdPlayer(CompactDisk compactDisk){
//        return new CDPlayer(compactDisk);
//    }

}
