package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.AuthorizationResponse;
import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 28.02.2017.
 */
public class LoginHandler implements AuthorizationHandler {
    public String getName() {
        return "login";
    }

    public String getRouteKey(Request<?> msg) {
        return null;
    }

    public ResponseData doHandle(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken("Получи ответ на запрос логина");
        //
        System.out.println(" Обрабатываю LoginRequest");
        System.out.println(" Запрошен: "+loginRequest.getDeviceToken());
        System.out.println(" Получен: "+loginResponse.getToken());
        //
        return loginResponse;
    }

    public Response<?> handle(Request<?> msg) {
        ResponseData responseData;
        Object loginData = msg.retData(msg);

        if (loginData instanceof LoginRequest){
            responseData = doHandle((LoginRequest)loginData);
            AuthorizationResponse<LoginResponse> authorizationResponse = new AuthorizationResponse<LoginResponse>();
            authorizationResponse.setData((LoginResponse) responseData);
            return authorizationResponse;
        }else {
            return null;
        }




    }
}
