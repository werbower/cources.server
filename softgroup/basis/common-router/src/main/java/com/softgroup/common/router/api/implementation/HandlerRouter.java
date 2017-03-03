package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import com.softgroup.common.router.api.interfaces.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 28.02.2017.
 */
public abstract class HandlerRouter extends AbstractRouter {
    @Autowired
    private List<AuthorizationHandler> listHandlers;

    @PostConstruct
    private void populateMap(){
        Map<String,Handler> mapHandlers = new HashMap<>();
        for (Handler handler : listHandlers) {
            mapHandlers.put(handler.getName(),handler);
        }
        setMap(mapHandlers);
    }
    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }


}
