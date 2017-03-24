package com.softgroup.common.dbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by user on 15.03.2017.
 */
public class CommonDaoService<W extends PagingAndSortingRepository<T,S>, T,S extends Serializable> {
    @Autowired
    protected W rep;
    //

    public T save(T s) {
        return rep.save(s);
    }


    public T findOne(S s) {
        return rep.findOne(s);
    }


    public void delete(S s) {
        rep.delete(s);
    }



}
