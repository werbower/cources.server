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
    @Column(name = "request_uuid")
    private String requestUuid;
    //
    @Column(name = "timeout")
    private Long timeout;
    //
    @Column(name = "auth_code")
    private String authCode;
    //
    @Column(name = "phone_number")
    private String phoneNumber;

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

    public String getRequestUuid() {
        return requestUuid;
    }

    public void setRequestUuid(String requestUuid) {
        this.requestUuid = requestUuid;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //</editor-fold>
}
