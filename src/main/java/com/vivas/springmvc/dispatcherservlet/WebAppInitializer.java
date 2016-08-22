package com.vivas.springmvc.dispatcherservlet;

import com.vivas.springmvc.config.RootConfig;
import com.vivas.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by duyot on 8/18/2016.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
}
