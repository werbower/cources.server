package com.softgroup.common.dbase.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Odin on 29.02.2016.
 */
@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity implements Serializable {

    private static final long serialVersionUID = 2645460488213358603L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "settings_data")
    private String settingsData;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProfileEntity profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        if (!id.equals(that.id)) return false;
        return settingsData.equals(that.settingsData);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + settingsData.hashCode();
        return result;
    }
}