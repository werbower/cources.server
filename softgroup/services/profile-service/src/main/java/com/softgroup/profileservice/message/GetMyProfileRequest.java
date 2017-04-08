package com.softgroup.profileservice.message;

import com.softgroup.common.protocol.RequestData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class GetMyProfileRequest implements RequestData{

	private static final long serialVersionUID = -4110573437301832702L;
	private String profileId;
	//


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
}