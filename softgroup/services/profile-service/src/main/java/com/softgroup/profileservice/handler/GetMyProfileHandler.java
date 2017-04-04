package com.softgroup.profileservice.handler;

import com.softgroup.common.dbase.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.interfaces.ProfileHandler;
import com.softgroup.profileservice.message.GetMyProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class GetMyProfileHandler implements ProfileHandler {
    public String getName() {
        return "getMyProfile";
    }

    @Autowired
    ProfileService profileService;

    public Response<GetMyProfileResponse> doHandle(String profileId) {
        System.out.println(" Обрабатываю GetMyProfileRequest");
        Response<GetMyProfileResponse> response = new Response<>();

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(200);
        responseStatus.setMessage("ok");
        response.setStatus(responseStatus);
        //
        GetMyProfileResponse responseData= new GetMyProfileResponse();
        responseData.setProfileEntity(profileService.findById(profileId));
        response.setData(responseData);

        return response;
    }

    public Response<?> handle(Request<?> msg) {
        String profileId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (profileId!=null){

            Response<GetMyProfileResponse> response = doHandle(profileId);
            response.setHeader(msg.getHeader());
            return response;
        }else {
            return null;
        }
    }
}
