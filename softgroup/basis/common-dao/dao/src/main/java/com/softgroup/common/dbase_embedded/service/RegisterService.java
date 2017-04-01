package com.softgroup.common.dbase_embedded.service;

import com.softgroup.common.dbase_embedded.dao.RegisterRepository;
import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 31.03.2017.
 */
@Service
@Transactional(value = "transactionManager_Embedded")
public class RegisterService extends DaoServiceEmbedded<RegisterRepository,RegisterEntity,String> {

    @Transactional(
            isolation = Isolation.SERIALIZABLE
    )
    public RegisterEntity findOrCreateRegister(RegisterEntity registerEntity){

        RegisterEntity foundEntity = rep.findByPhoneDeviceQuery(
                registerEntity.getPhoneNumber(),registerEntity.getDeviceId());

        if (foundEntity == null){
            System.out.println(" в базе нет элемента с телефоном "+registerEntity.getPhoneNumber()+
            "и девайсом "+registerEntity.getDeviceId());
            //
            foundEntity = save(registerEntity);
        }
        return foundEntity;
    }
    //


    public void deleteExpiredQuery(Long curTime){
        rep.deleteExpiredQuery(curTime);
    }
    //
    public RegisterEntity findByIdAuthCodeQuery(String id,String authCode){
        return rep.findByIdAuthCodeQuery(id,authCode);
    }

}
