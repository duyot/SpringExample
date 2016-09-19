package com.vivas.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by duyot on 8/18/2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.vivas.springmvc")
public class WebConfig extends WebMvcConfigurerAdapter {


    //view resolver with theme leaf
//    view resolver with apache tile
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

//    view resolver nomal
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        resolver.setOrder(0);
//        return resolver;
//    }

    @Override
    public void configureDefaultServletHandling(
                DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
