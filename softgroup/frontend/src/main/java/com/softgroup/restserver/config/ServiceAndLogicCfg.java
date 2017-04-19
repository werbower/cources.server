package com.softgroup.restserver.config;

import com.softgroup.authorization.api.AuthorizationConfig;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.dbase.config.CommonDaoAppCfg;
import com.softgroup.common.dbase_embedded.config.CommonDaoAppCfg2;
import com.softgroup.common.modelmapper.ModelMapperCfg;
import com.softgroup.firstrouter.api.FirstRouterConfig;
import com.softgroup.profileservice.ProfileServiceConfig;
import com.softgroup.token.TokenConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        //logic
        AuthorizationConfig.class
        , ProfileServiceConfig.class
        , FirstRouterConfig.class
        //services
        , CommonDaoAppCfg.class
        , CommonDaoAppCfg2.class
        , TokenConfig.class
        , DataMapperAppCfg.class
        , ModelMapperCfg.class

})

public class ServiceAndLogicCfg {
}
