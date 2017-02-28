package com.softgroup.common.router.api.interfaces;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

public interface Handler {
    String getName();
    String getRouteKey(final Request<?> msg);
    Response<?> handle(final Request<?> msg);

}
