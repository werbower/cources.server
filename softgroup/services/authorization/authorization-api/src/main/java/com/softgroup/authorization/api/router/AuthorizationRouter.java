package com.softgroup.authorization.api.router;

import com.softgroup.common.router.api.implementation.HandlerRouter;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import com.softgroup.common.router.api.interfaces.RouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 27.02.2017.
 */
@Component
public class AuthorizationRouter extends HandlerRouter<AuthorizationHandler> implements RouterHandler {


    public String getName() {
        return "authorization";
    }





}
