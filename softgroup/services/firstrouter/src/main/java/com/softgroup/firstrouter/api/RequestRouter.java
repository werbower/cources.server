package com.softgroup.firstrouter.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.implementation.AbstractRouter;
import com.softgroup.common.router.api.interfaces.Handler;
import com.softgroup.common.router.api.interfaces.RequestHandler;
import com.softgroup.common.router.api.interfaces.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class RequestRouter extends AbstractRouter implements RequestHandler{

    @Autowired
    List<RouterHandler> listRouters;
    @PostConstruct
    private void populateMap(){
        Map<String,Handler> mapHandlers = new HashMap<>();
        for (Handler handler : listRouters) {
            mapHandlers.put(handler.getName(),handler);
        }
        setMap(mapHandlers);
    }

    @Override
    public String getName() {
        return "request router";
    }


    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }




}
