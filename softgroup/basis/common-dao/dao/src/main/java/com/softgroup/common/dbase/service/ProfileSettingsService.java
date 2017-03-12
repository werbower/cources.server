package com.softgroup.common.dbase.service;

import com.softgroup.common.dbase.dao.ProfileSettingsDao;
import com.softgroup.common.dbase.dao.ProfileSettingsRepository;
import com.softgroup.common.dbase.model.ProfileSettingsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 12.03.2017.
 */
@Service("ProfileService")
public class ProfileSettingsService implements ProfileSettingsDao{
    @Autowired
    ProfileSettingsRepository profileSettingsRepository;

    @Override
    public ProfileSettingsEntity save(ProfileSettingsEntity s) {
        return profileSettingsRepository.save(s);
    }

    @Override
    public ProfileSettingsEntity findOne(String s) {
        return profileSettingsRepository.findOne(s);
    }

    @Override
    public void delete(String s) {
        profileSettingsRepository.delete(s);
    }
}
