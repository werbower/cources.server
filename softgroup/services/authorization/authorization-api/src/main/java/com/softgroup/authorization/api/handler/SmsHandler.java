package com.softgroup.authorization.api.handler;

import com.softgroup.authorization.api.message.SmsRequest;
import com.softgroup.authorization.api.message.SmsResponse;
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

/**
 * Created by user on 28.02.2017.
 */
@Component
public class SmsHandler implements AuthorizationHandler {
    public String getName() {
        return "sms_confirm";
    }

    @Autowired
    DataMapper dataMapper;
    @Autowired
    RegisterService registerService;
    @Autowired
    JwtApi jwtService;



    public SmsResponse doHandle(SmsRequest smsRequest, ResponseStatus responseStatus) {
        //
        System.out.println(" Обрабатываю SmsRequest");
        //
        responseStatus.setCode(200);
        responseStatus.setMessage("ok");
        SmsResponse response= new SmsResponse();
        long curTime  = new Date(System.currentTimeMillis()).getTime();

        registerService.deleteExpiredQuery(curTime);
        RegisterEntity registerEntity = registerService.findByIdAuthCodeQuery(smsRequest.getRegistrationRequestUuid(),
                                                                                smsRequest.getAuthCode());
        if (registerEntity==null){
            responseStatus.setCode(400);
            responseStatus.setMessage("Bad auth code");
        } else {
            long timeout = 60*1000L;
            response.setDeviceToken(jwtService.tokenFromRegister(registerEntity,timeout));
        }

        System.out.println(" Сформирован token: "+response.getDeviceToken());
        return response;
    }

    public Response<?> handle(Request<?> msg) {
        SmsRequest requestData = dataMapper.convert((Map<String,Object>)msg.getData(), SmsRequest.class);

        if (requestData instanceof SmsRequest){
            ResponseStatus responseStatus = new ResponseStatus();
            SmsResponse responseData = doHandle(requestData,responseStatus);

            Response<SmsResponse> response = new Response<>();
            response.setHeader(msg.getHeader());
            response.setData(responseData);
            response.setStatus(responseStatus);
            return response;
        }else {
            return null;
        }
    }
}
