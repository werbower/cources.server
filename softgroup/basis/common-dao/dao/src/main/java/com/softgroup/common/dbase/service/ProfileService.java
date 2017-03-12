package com.softgroup.common.dbase.service;

import com.softgroup.common.dbase.dao.ProfileDao;
import com.softgroup.common.dbase.dao.ProfileRepository;
import com.softgroup.common.dbase.model.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12.03.2017.
 */
@Service
public class ProfileService implements ProfileDao{
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public ProfileEntity save(ProfileEntity s) {
        return profileRepository.save(s);
    }

    @Override
    public ProfileEntity findOne(String s) {
        return profileRepository.findOne(s);
    }

    @Override
    public void delete(String s) {
        profileRepository.delete(s);
    }

    @Override
    public List<ProfileEntity> findByName(String s) {
        return profileRepository.findByName(s);
    }

    @Override
    public List<ProfileEntity> findByNameQuery(String s) {
        return profileRepository.findByNameQuery(s);
    }
}
