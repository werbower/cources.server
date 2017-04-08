package com.softgroup.profileservice.handler;

import com.softgroup.common.dbase.DTO.ProfileDTO;
import com.softgroup.common.dbase.service.ProfileServiceDTO;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusEnum;
import com.softgroup.common.router.api.implementation.AbstractHandler;
import com.softgroup.profileservice.message.GetMyProfileRequest;
import com.softgroup.profileservice.message.GetMyProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by user on 28.02.2017.
 */
@Component
public class GetMyProfileHandler extends AbstractHandler<GetMyProfileResponse,GetMyProfileRequest> implements ProfileHandler {
    public String getName() {
        return "getMyProfile";
    }

    @Autowired
    ProfileServiceDTO profileService;

    public GetMyProfileHandler() {
        super(GetMyProfileRequest.class);
    }

    @Override
    public Response<?> doHandle(Response<GetMyProfileResponse> response, GetMyProfileRequest requestData) {
        //ProfileDTO profileDTO = profileService.findOne(requestData.getProfileId());
        ProfileDTO profileDTO = profileService.findOne((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (profileDTO==null){
            response.setStatus(ResponseStatusEnum.NOT_FOUND);
        }else {
            GetMyProfileResponse responseData = new GetMyProfileResponse();
            responseData.setProfile(profileDTO);
            response.setData(responseData);
        }
        return response;
    }

}
