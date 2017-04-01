package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import com.softgroup.common.dbase_embedded.service.RegisterService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.interfaces.AuthorizationHandler;
import com.softgroup.token.JwtApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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
    RegisterService registerService;
    @Autowired
    JwtApi jwtService;

    public String getName() {
        return "register";
    }



    public RegisterResponse doHandle(RegisterRequest registerRequest, ResponseStatus responseStatus) {
        String phoneNumber = (registerRequest.getPhoneNumber()==null)?"unknown":registerRequest.getPhoneNumber();
        String deviceId = (registerRequest.getDeviceId()==null)?"unknown":registerRequest.getDeviceId();
        //
        responseStatus.setCode(200);
        responseStatus.setMessage("ok");
        //
        System.out.println(" Обрабатываю RegisterRequest");
        System.out.println("получен ид девайса: "+deviceId);
        System.out.println("получен номер телефона "+phoneNumber);
        //
        RegisterResponse response= new RegisterResponse();
        //
        long curTime  = new Date(System.currentTimeMillis()).getTime();
        long timeout = 20*1000L;
        String strUuid = UUID.randomUUID().toString();
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setId(strUuid);
        registerEntity.setDeviceId(deviceId);
        registerEntity.setPhoneNumber(phoneNumber);
        registerEntity.setTimeCreated(curTime);
        registerEntity.setTimeClosed(curTime+timeout);
        String strTimeClosed = registerEntity.getTimeClosed().toString();
        String strAuthCode = strTimeClosed.substring(strTimeClosed.length()-5);
        registerEntity.setAuthCode(strAuthCode);
        //
        registerService.deleteExpiredQuery(curTime);
        registerEntity = registerService.findOrCreateRegister(registerEntity);
        if (!registerEntity.getId().equals(strUuid)){ //not allowed
            responseStatus.setCode(429);
            responseStatus.setMessage("Too Many Requests");
        }
        //
        response.setRegistrationRequestUuid(registerEntity.getId());
        response.setRegistrationTimeoutSec(""+(registerEntity.getTimeClosed()-curTime)/1000);
        response.setAuthCode(registerEntity.getAuthCode());
        //
        System.out.println(" Сформирован код аутентификации: "+response.getAuthCode());
        //
        return response;
    }

    public Response<?> handle(Request<?> msg) {
        RegisterRequest registerData = dataMapper.convert((Map<String,Object>)msg.getData(), RegisterRequest.class);

        if (registerData instanceof RegisterRequest){
            ResponseStatus responseStatus = new ResponseStatus();
            RegisterResponse responseData = doHandle(registerData,responseStatus);
            Response<RegisterResponse> response = new Response<>();
            response.setHeader(msg.getHeader());
            response.setData( responseData);
            response.setStatus(responseStatus);
            return response;
        }else {
            return null;
        }
    }
}
