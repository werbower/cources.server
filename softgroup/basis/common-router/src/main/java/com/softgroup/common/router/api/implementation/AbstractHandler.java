package com.softgroup.common.router.api.implementation;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusEnum;
import com.softgroup.common.router.api.interfaces.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by user on 08.04.2017.
 */
public abstract class AbstractHandler<W extends Serializable,V> implements Handler {
    Class<V> typeRequestData;
    @Autowired
    DataMapper dataMapper;

    public AbstractHandler(Class<V> typeRequestData) {
        this.typeRequestData = typeRequestData;
    }
    public abstract Response<?> doHandle(Response<W> response,V requestData);

    @Override
    public Response<?> handle(Request<?> msg) {
        Response<W> response = Response.buildResponse(msg);
        V requestData;
        try {
            requestData = dataMapper.convert((Map<String,Object>)msg.getData(), typeRequestData);
        } catch (Exception ex){
            response.setStatus(ResponseStatusEnum.BAD_REQUEST);
            return response;
        }
        return doHandle(response,requestData);
    }
}
