package com.softgroup.common.dbase_embedded.dao;

import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 31.03.2017.
 */
public interface RegisterRepository extends PagingAndSortingRepository<RegisterEntity,String> {

    @Query("select p from RegisterEntity p where p.phoneNumber = :phoneNumber and p.deviceId = :deviceId")
    RegisterEntity findByPhoneDeviceQuery(@Param("phoneNumber") String s, @Param("deviceId") String d);

    @Modifying
    @Query("delete  from RegisterEntity p where p.timeClosed < :curTime")
    void deleteExpiredQuery(@Param("curTime") Long curTime);

    @Query("select p from RegisterEntity p " +
            "where p.id = :id and p.authCode = :authCode")
    RegisterEntity findByIdAuthCodeQuery(@Param("id") String id, @Param("authCode") String authCode);


}
