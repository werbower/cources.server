package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusEnum;
import com.softgroup.common.router.api.interfaces.Handler;

import java.util.Map;

/**
 * Created by user on 28.02.2017.
 */
public abstract class AbstractRouter implements Handler {
    private Map<String,Handler> map;

    public void setMap(Map<String, Handler> map) {
        this.map = map;
    }

    public Map<String, Handler> getMap() {
        return map;
    }
    public abstract String getRouteKey(final Request<?> msg);

    @Override
    public Response<?> handle(Request<?> msg) {
        String routeKey = getRouteKey(msg);
        Handler handler = getMap().get(routeKey);
        if (handler==null){
            Response<?> response = Response.buildResponse(msg, ResponseStatusEnum.BAD_REQUEST
                    ,"bad request type/command "+routeKey);
            return response;
        } else {
            return handler.handle(msg);
        }

    }
}
