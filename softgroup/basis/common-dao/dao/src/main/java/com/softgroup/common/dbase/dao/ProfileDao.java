package com.softgroup.common.dbase.dao;

import com.softgroup.common.dbase.model.ProfileEntity;

import java.util.List;

/**
 * Created by user on 12.03.2017.
 */

public interface ProfileDao {
    public ProfileEntity save(ProfileEntity s);
    public ProfileEntity findOne(String s);
    public void delete(String s);
    List<ProfileEntity> findByName(String s);
    List<ProfileEntity> findByNameQuery(String s);

}
