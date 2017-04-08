package com.softgroup.common.dbase.DTO;

import java.io.Serializable;

/**
 * Created by user on 08.04.2017.
 */
public class ProfileDTO implements Serializable {
    private static final long serialVersionUID = 3996302779646967906L;
    String phoneNumber;
    String name;
    //

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
