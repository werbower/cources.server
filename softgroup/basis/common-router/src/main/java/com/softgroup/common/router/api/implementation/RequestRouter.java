package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.interfaces.RequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class RequestRouter extends AbstractRouter implements RequestHandler{
    @Override
    public String getName() {
        return "request router";
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }


}
