package com.softgroup.common.dbase.dao;


import com.softgroup.common.dbase.model.ProfileSettingsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Odin on 03.03.2017.
 */
public interface ProfileSettingsRepository extends PagingAndSortingRepository<ProfileSettingsEntity, String> {

}
