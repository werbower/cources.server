package com.softgroup.common.router.api.implementation;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.interfaces.Handler;

/**
 * Created by user on 08.04.2017.
 */
public abstract class AbstractHandler implements Handler {
    public abstract Response<?> doHandle(Request<?> request);

    @Override
    public Response<?> handle(Request<?> msg) {
        return doHandle(msg);
    }
}
