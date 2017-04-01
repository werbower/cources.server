package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.dbase.service.ProfileService;
import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import com.softgroup.token.JwtApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class LoginHandler implements AuthorizationHandler {
    public String getName() {
        return "login";
    }

    @Autowired
    DataMapper dataMapper;
    @Autowired
    ProfileService profileService;
    @Autowired
    JwtApi jwtService;



    public LoginResponse doHandle(LoginRequest loginRequest, ResponseStatus responseStatus) {
        //
        System.out.println(" Обрабатываю LoginRequest");
        //
        responseStatus.setCode(200);
        responseStatus.setMessage("ok");
        LoginResponse response= new LoginResponse();
        long curTime  = new Date(System.currentTimeMillis()).getTime();


        RegisterEntity registerEntity = jwtService.registerFromToken(loginRequest.getDeviceToken());
        if (registerEntity==null){
            responseStatus.setCode(400);
            responseStatus.setMessage("Bad device token");
        } else {
            long timeout = 1*60*60*1000L;
            String phoneNumber = registerEntity.getPhoneNumber();
            ProfileEntity profileEntity = profileService.findOrCreateProfile(phoneNumber);
            String token = jwtService.tokenFromProfile(profileEntity);
            response.setToken(token);
        }

        System.out.println(" Сформирован token: "+response.getToken());
        return response;
    }

    public Response<?> handle(Request<?> msg) {
        LoginRequest requestData = dataMapper.convert((Map<String,Object>)msg.getData(), LoginRequest.class);

        if (requestData instanceof LoginRequest){
            ResponseStatus responseStatus = new ResponseStatus();
            LoginResponse responseData = doHandle(requestData,responseStatus);

            Response<LoginResponse> response = new Response<>();
            response.setHeader(msg.getHeader());
            response.setData(responseData);
            response.setStatus(responseStatus);
            return response;
        }else {
            return null;
        }
    }
}
