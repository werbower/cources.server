package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.interfaces.Handler;

/**
 * Created by user on 28.02.2017.
 */
public abstract class HandlerRouter extends AbstractRouter {
    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        Handler handler = getMap().get(getRouteKey(msg));
        return handler.handle(msg);
    }
}
