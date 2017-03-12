package com.softgroup.common.dbase.dao;

import com.softgroup.common.dbase.model.ProfileSettingsEntity;

/**
 * Created by user on 12.03.2017.
 */

public interface ProfileSettingsDao {
    public ProfileSettingsEntity save(ProfileSettingsEntity s);
    public ProfileSettingsEntity findOne(String s);
    public void delete(String s);

}
