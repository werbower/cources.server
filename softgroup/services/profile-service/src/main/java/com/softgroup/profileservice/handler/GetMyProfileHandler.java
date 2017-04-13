package com.softgroup.profileservice.handler;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.dbase.DTO.ProfileDTO;
import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.dbase.service.ProfileService;
import com.softgroup.common.modelmapper.ModelMapperInterface;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatusEnum;
import com.softgroup.common.router.api.implementation.AbstractHandler;
import com.softgroup.profileservice.message.GetMyProfileRequest;
import com.softgroup.profileservice.message.GetMyProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetMyProfileHandler extends AbstractHandler implements ProfileHandler {
    public String getName() {
        return "get_my_profile";
    }

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ModelMapperInterface modelMapper;
    @Autowired
    private DataMapper dataMapper;

    @Override
    public Response<?> doHandle(Request<?> request) {

        GetMyProfileRequest requestData;
        try {
            requestData = dataMapper.convert((Map<String, Object>) request.getData(),GetMyProfileRequest.class);
        } catch (Exception e){
            return Response.buildResponse(request,ResponseStatusEnum.BAD_REQUEST,"bad request data");
        }
        ProfileEntity profile = profileService.findOne(request.getHeader().getUuid());

        if (profile==null){
            return Response.buildResponse(request,ResponseStatusEnum.NOT_FOUND,"not found profile");
        }

        Response<GetMyProfileResponse> response = Response.buildResponse(request);
        GetMyProfileResponse responseData = new GetMyProfileResponse();
        responseData.setProfile(modelMapper.map(profile,ProfileDTO.class));
        response.setData(responseData);
        return response;
    }

}
