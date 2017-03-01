package com.softgroup.authorization.api.router;

import com.softgroup.authorization.api.handler.LoginHandler;
import com.softgroup.authorization.api.handler.RegisterHandler;
import com.softgroup.common.router.api.implementation.HandlerRouter;
import com.softgroup.common.router.api.interfaces.Handler;
import com.softgroup.common.router.api.interfaces.RouterHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 27.02.2017.
 */
public class AuthorizationRouter extends HandlerRouter implements RouterHandler {

    public String getName() {
        return "authorization";
    }

    public AuthorizationRouter() {
        Map<String,Handler> mapH = new HashMap<>();
        //
        LoginHandler loginHandler = new LoginHandler();
        mapH.put(loginHandler.getName(),loginHandler);
        //
        RegisterHandler registerHandler = new RegisterHandler();
        mapH.put(registerHandler.getName(),registerHandler);

        setMap(mapH);
    }

}
