package com.softgroup.common.dbase.service;

import com.softgroup.common.dbase.dao.ProfileRepository;
import com.softgroup.common.dbase.model.ProfileEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 12.03.2017.
 */
@Service
@Transactional(value = "transactionManager")
public class ProfileService extends CommonDaoService<ProfileRepository,ProfileEntity,String> {

    public List<ProfileEntity> findByName(String s) {
        return rep.findByName(s);
    }

    public List<ProfileEntity> findByNameQuery(String s) {
        return rep.findByNameQuery(s);
    }

    @Transactional(
            isolation = Isolation.SERIALIZABLE
    )
    public ProfileEntity findOrCreateProfile(String phoneNumber){
        ProfileEntity foundEntity = rep.findByPhoneNumberQuery(phoneNumber);

        if (foundEntity == null){
            System.out.println(" в базе нет элемента с телефоном "+phoneNumber);
            ProfileEntity newEntity = new ProfileEntity();
            newEntity.setId(UUID.randomUUID().toString());
            newEntity.setName("unknown");
            newEntity.setPhoneNumber(phoneNumber);
            newEntity.setCreateDateTime(new Date(System.currentTimeMillis()).getTime());
            foundEntity = save(newEntity);
        }
        return foundEntity;
    }
    //


}
