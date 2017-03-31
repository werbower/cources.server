package com.softgroup.common.dbase_embedded.dao;

import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by user on 31.03.2017.
 */
public interface RegisterRepository extends PagingAndSortingRepository<RegisterEntity,String> {

}
