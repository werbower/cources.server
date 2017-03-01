package com.softgroup.authorization.api.router;

import com.softgroup.authorization.api.handler.AuthorizationHandler;
import com.softgroup.common.router.api.implementation.HandlerRouter;
import com.softgroup.common.router.api.interfaces.Handler;
import com.softgroup.common.router.api.interfaces.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 27.02.2017.
 */
@Component
public class AuthorizationRouter extends HandlerRouter implements RouterHandler {
    @Autowired
    private List<AuthorizationHandler> listHandlers;

    public String getName() {
        return "authorization";
    }

    private Map<String,Handler> populateMap(){
        Map<String,Handler> mapHandlers = new HashMap<>();
        for (Handler handler : listHandlers) {
            mapHandlers.put(handler.getName(),handler);
        }
        return mapHandlers;
    }

    public AuthorizationRouter() {
//        Map<String,Handler> mapH = new HashMap<>();
//        //
//        LoginHandler loginHandler = new LoginHandler();
//        mapH.put(loginHandler.getName(),loginHandler);
//        //
//        RegisterHandler registerHandler = new RegisterHandler();
//        mapH.put(registerHandler.getName(),registerHandler);

//        setMap(mapH);
        setMap(populateMap());
    }

}
