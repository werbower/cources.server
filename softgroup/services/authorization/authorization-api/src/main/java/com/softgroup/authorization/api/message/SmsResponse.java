package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 27.02.2017.
 */
public class SmsResponse implements ResponseData {

    private static final long serialVersionUID = -6923538163764454748L;

    private String deviceToken;

    //<editor-fold desc="Getters & Setters">

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
    //</editor-fold>
}
