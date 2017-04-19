package com.softgroup.profileservice.message;

import com.softgroup.common.dbase.DTO.ProfileDTO;
import com.softgroup.common.protocol.ResponseData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class GetMyProfileResponse implements ResponseData {
	private static final long serialVersionUID = -9050275052081396657L;
	private ProfileDTO profile;

	//<editor-fold desc="getters&setters">
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}
	//</editor-fold>
}



