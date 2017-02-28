package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Response;

import java.io.Serializable;

/**
 * Created by user on 28.02.2017.
 */
public class AuthorizationResponse<T extends Serializable> extends Response<T> {
    public AuthorizationResponse() {
        ActionHeader actionHeader = new ActionHeader();
        actionHeader.setType("authorization");
        setHeader(actionHeader);
    }
}
