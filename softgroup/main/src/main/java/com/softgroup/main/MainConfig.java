package com.softgroup.main;

import com.softgroup.authorization.api.AuthorizationConfig;
import com.softgroup.common.router.api.RouterConfig;
import com.softgroup.firstrouter.api.FirstRouterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by user on 01.03.2017.
 */
@Configuration
@Import({RouterConfig.class
        , AuthorizationConfig.class
        , FirstRouterConfig.class})

public class MainConfig {
}
