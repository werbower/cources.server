package com.softgroup.profileservice.message;

import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class GetMyProfileResponse implements ResponseData {
	private static final long serialVersionUID = -9050275052081396657L;
	private ProfileEntity profileEntity;

	//<editor-fold desc="getters&setters">
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public ProfileEntity getProfileEntity() {
		return profileEntity;
	}

	public void setProfileEntity(ProfileEntity profileEntity) {
		this.profileEntity = profileEntity;
	}
	//</editor-fold>
}



