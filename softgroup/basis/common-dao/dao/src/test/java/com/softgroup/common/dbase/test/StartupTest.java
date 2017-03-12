package com.softgroup.common.dbase.test;


import com.softgroup.common.dbase.config.CommonDaoAppCfg;
import com.softgroup.common.dbase.dao.ProfileDao;
import com.softgroup.common.dbase.dao.ProfileSettingsDao;
import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.dbase.model.ProfileSettingsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Odin on 04.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class StartupTest {

    @Autowired
    ProfileDao profileService;
    @Autowired
    ProfileSettingsDao profileSettingsService;

    @Test
    public void test(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("id");
        profileEntity.setName("test_name");

        profileEntity = profileService.save(profileEntity);

        ProfileSettingsEntity settingsEntity = new ProfileSettingsEntity();
        settingsEntity.setId("1");
        settingsEntity.setSettingsData("data_1");
        settingsEntity.setProfile(profileEntity);

        settingsEntity = profileSettingsService.save(settingsEntity);

        ProfileSettingsEntity settingsEntity1 = new ProfileSettingsEntity();
        settingsEntity1.setId("2");
        settingsEntity1.setSettingsData("data_2");
        settingsEntity1.setProfile(profileEntity);

        settingsEntity1 = profileSettingsService.save(settingsEntity1);

        profileEntity.setSettingsEntities(Arrays.asList(settingsEntity, settingsEntity1));

        profileEntity = profileService.save(profileEntity);

        ProfileEntity profile = profileService.findOne("id");

        List<ProfileSettingsEntity> settings = profile.getSettingsEntities();

        List<ProfileEntity> profileEntities = profileService.findByName("name_2");

        List<ProfileEntity> profileEntitiesByQuery = profileService.findByNameQuery("test_name");

    }
}
