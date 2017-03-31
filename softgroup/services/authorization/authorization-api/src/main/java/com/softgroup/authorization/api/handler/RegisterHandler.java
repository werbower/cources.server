package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.AuthorizationResponse;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.dbase.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import com.softgroup.token.JwtApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class RegisterHandler implements AuthorizationHandler {
    @Autowired
    DataMapper dataMapper;
    @Autowired
    ProfileService profileService;
    @Autowired
    JwtApi jwtService;

    public String getName() {
        return "register";
    }



    public RegisterResponse doHandle(RegisterRequest registerRequest) {

        String phoneNumber = registerRequest.getPhoneNumber();
        System.out.println("получен номер телефона "+phoneNumber);
        ProfileEntity registeredProfile = profileService.findOrCreateProfile(phoneNumber);
        String xToken = jwtService.tokenFromProfile(registeredProfile);



        RegisterResponse response= new RegisterResponse();
        response.setAuthCode(xToken);
        response.setRegistrationRequestUuid(UUID.randomUUID().toString());
        response.setRegistrationTimeoutSec("20");
        //
        System.out.println(" Обрабатываю RegisterRequest");
        System.out.println(" Запрошен ид девайса: "+registerRequest.getDeviceId());
        System.out.println(" Получен код аутентификации: "+response.getAuthCode());
        //
        return response;
    }

    public Response<?> handle(Request<?> msg) {
        RegisterRequest registerData = dataMapper.convert((Map<String,Object>)msg.getData(), RegisterRequest.class);

        if (registerData instanceof RegisterRequest){
            RegisterResponse responseData = doHandle(registerData);
            AuthorizationResponse<RegisterResponse> authorizationResponse = new AuthorizationResponse<>();
            authorizationResponse.setData( responseData);
            return authorizationResponse;
        }else {
            return null;
        }




    }
}
