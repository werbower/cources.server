package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 27.02.2017.
 */
public class SmsRequest implements RequestData {
    private static final long serialVersionUID = -3995540693890548655L;
    private String authCode;
    private String registrationRequestUuid;

    //<editor-fold desc="Getters & Setters">
    public String getAuthCode() {
        return authCode;
    }

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }
    //</editor-fold>
}
