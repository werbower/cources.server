package com.softgroup.common.dbase_embedded.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 31.03.2017.
 */
@Entity
@Table(name = "register")
public class RegisterEntity implements Serializable {
    private static final long serialVersionUID = -7061706991598381767L;

    @Id
    @Column(name = "id")
    private String id;
    //
    @Column(name = "device_id")
    private String deviceId;
    //
    @Column(name = "time_created")
    private Long timeCreated;
    //
    @Column(name = "time_closed")
    private Long timeClosed;
    //
    @Column(name = "phone_number")
    private String phoneNumber;
    //
    @Column(name = "auth_code")
    private String authCode;

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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getTimeClosed() {
        return timeClosed;
    }

    public void setTimeClosed(Long timeClosed) {
        this.timeClosed = timeClosed;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    //</editor-fold>
}
