package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 27.02.2017.
 */
public class SmsResponse implements ResponseData {

    private static final long serialVersionUID = -6923538163764454748L;

    private String authCode;
    private String registrationRequestUuid;

    //<editor-fold desc="Getters & Setters">
    public String getAuthCode() {
        return authCode;
    }

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setauthCode(String authCode) {
        this.authCode = authCode;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }
    //</editor-fold>
}
