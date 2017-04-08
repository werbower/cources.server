package com.softgroup.common.dbase.service;

import com.softgroup.common.dbase.DTO.ProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 08.04.2017.
 */
@Component
public class ProfileServiceDTO {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProfileService profileService;
    //

    public ProfileDTO findOne(String id){
        return modelMapper.map(profileService.findOne(id),ProfileDTO.class);
    }


}
