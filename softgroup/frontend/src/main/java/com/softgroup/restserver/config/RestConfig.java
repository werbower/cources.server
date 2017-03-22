package com.softgroup.restserver.config;

import com.softgroup.authorization.api.AuthorizationConfig;
import com.softgroup.common.router.api.RouterConfig;
import com.softgroup.firstrouter.api.FirstRouterConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//

/**
 * Created by user on 20.03.2017.
 */
@Configuration
@Import({RouterConfig.class
        , AuthorizationConfig.class
        , FirstRouterConfig.class

})

@EnableWebMvc
@ComponentScan("com.softgroup.restserver.controller")
public class RestConfig {

}
