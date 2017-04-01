package com.softgroup.common.dbase_embedded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by user on 31.03.2017.
 */
public class DaoServiceEmbedded<W extends PagingAndSortingRepository<T,S>, T,S extends Serializable> {
    @Autowired
    W rep;
    //
    public T save(T s){
        return rep.save(s);
    }

}
