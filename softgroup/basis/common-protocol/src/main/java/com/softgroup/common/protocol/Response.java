package com.softgroup.common.protocol;

import java.io.Serializable;

public class Response<T extends Serializable> extends RoutedAction<T> {
	private static final long serialVersionUID = 8979170551734666755L;

	private ResponseStatus status;

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	//helper
	public void setStatus(ResponseStatusEnum responseStatusEnum,String responseStatusMessage){
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(responseStatusEnum.getNumber());
		responseStatus.setMessage(responseStatusMessage);
		setStatus(responseStatus);
	}
	//helper
	public void setStatus(ResponseStatusEnum responseStatusEnum){
		setStatus(responseStatusEnum,responseStatusEnum.getDescription());
	}
	//builder
	public static <W extends Serializable> Response<W> buildResponse(Request<?> request
			, ResponseStatusEnum responseStatusEnum, String responseStatusMessage){
		Response<W> response = new Response<>();
		response.setHeader(request.getHeader());
		response.setStatus(responseStatusEnum,responseStatusMessage);
		return response;
	}
	//builder
	public static <W extends Serializable>Response<W> buildResponse(Request<?> request
			, ResponseStatusEnum responseStatusEnum){
		return buildResponse(request,responseStatusEnum,responseStatusEnum.getDescription());
	}
	//builder
	public static <W extends Serializable>Response<W> buildResponse(Request<?> request){
		return buildResponse(request,ResponseStatusEnum.OK);
	}

}
