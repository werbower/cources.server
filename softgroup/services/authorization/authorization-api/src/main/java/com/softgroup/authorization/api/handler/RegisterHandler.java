package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.*;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class RegisterHandler implements AuthorizationHandler {
    public String getName() {
        return "register";
    }

    public String getRouteKey(Request<?> msg) {
        return null;
    }

    public ResponseData doHandle(RegisterRequest registerRequest) {

        RegisterResponse response= new RegisterResponse();
        response.setAuthCode("код аутентификации");
        //
        System.out.println(" Обрабатываю RegisterRequest");
        System.out.println(" Запрошен ид девайса: "+registerRequest.getDeviceId());
        System.out.println(" Получен код аутентификации: "+response.getAuthCode());
        //
        return response;
    }

    public Response<?> handle(Request<?> msg) {
        ResponseData responseData;
        Object registerData = msg.retData(msg);

        if (registerData instanceof RegisterRequest){
            responseData = doHandle((RegisterRequest)registerData);
            AuthorizationResponse<RegisterResponse> authorizationResponse = new AuthorizationResponse<>();
            authorizationResponse.setData((RegisterResponse) responseData);
            return authorizationResponse;
        }else {
            return null;
        }




    }
}
