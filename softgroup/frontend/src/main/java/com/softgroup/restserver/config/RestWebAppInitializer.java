package com.softgroup.restserver.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by user on 20.03.2017.
 */
public class RestWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        WebApplicationContext wac =super.createServletApplicationContext();
        ConfigurableEnvironment ce = (ConfigurableEnvironment)wac.getEnvironment();
        ce.setDefaultProfiles("release");
        //System.out.println("profile: "+ce.getProperty("spring.profiles.active").toString());
        return wac;
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RestConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
