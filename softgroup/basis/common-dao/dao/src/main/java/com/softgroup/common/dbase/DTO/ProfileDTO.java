package com.softgroup.common.dbase.DTO;

import java.io.Serializable;

/**
 * Created by user on 08.04.2017.
 */
public class ProfileDTO implements Serializable {
    private static final long serialVersionUID = 3996302779646967906L;
    private String id;
    private String phoneNumber;
    private String name;

    //<editor-fold desc="getters & setters">
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>
}
