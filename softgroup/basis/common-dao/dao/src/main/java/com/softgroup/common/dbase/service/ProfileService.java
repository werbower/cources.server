package com.softgroup.common.dbase.service;

import com.softgroup.common.dbase.dao.ProfileRepository;
import com.softgroup.common.dbase.model.ProfileEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12.03.2017.
 */
@Service
public class ProfileService extends CommonDaoService<ProfileRepository,ProfileEntity,String>
        {

    public List<ProfileEntity> findByName(String s) {
        return rep.findByName(s);
    }

    public List<ProfileEntity> findByNameQuery(String s) {
        return rep.findByNameQuery(s);
    }


}
