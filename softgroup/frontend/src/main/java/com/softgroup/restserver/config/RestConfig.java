package com.softgroup.restserver.config;

import com.softgroup.authorization.api.AuthorizationConfig;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.dbase.config.CommonDaoAppCfg;
import com.softgroup.common.router.api.RouterConfig;
import com.softgroup.firstrouter.api.FirstRouterConfig;
import com.softgroup.token.TokenConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

//

/**
 * Created by user on 20.03.2017.
 */
@Configuration
@Import({RouterConfig.class
        , AuthorizationConfig.class
        , FirstRouterConfig.class
        , CommonDaoAppCfg.class
        , TokenConfig.class
        , DataMapperAppCfg.class

})

@EnableWebMvc
@ComponentScan("com.softgroup.restserver.controller")
public class RestConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);
    }
}
