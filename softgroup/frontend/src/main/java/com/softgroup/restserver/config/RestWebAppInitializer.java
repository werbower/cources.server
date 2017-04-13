package com.softgroup.restserver.config;

import com.softgroup.restserver.config.security.SecurityConfig;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
        return new Class<?>[]{ServiceAndLogicCfg.class, SecurityConfig.class};
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
