package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;

import java.io.Serializable;

/**
 * Created by user on 27.02.2017.
 */
public class AuthorizationRequest<T extends Serializable> extends Request<T> {
    public AuthorizationRequest() {
        ActionHeader aHeader = new ActionHeader();
        aHeader.setType("authorization");
        setHeader(aHeader);
    }
}
