package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;

/**
 * Created by user on 28.02.2017.
 */
public abstract class HandlerRouter extends AbstractRouter {
    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }


}
