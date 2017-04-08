package com.softgroup.common.protocol;

/**
 * Created by user on 08.04.2017.
 */
public enum  ResponseStatusEnum {
    OK(200,"ok"),
    BAD_REQUEST(400,"bad request"),
    FORBIDDEN(403,"forbidden"),
    NOT_FOUND(404,"not found"),
    NOT_ACCEPTABLE(406,"not acceptable"),
    UNPROCESSABLE_ENTITY(422,"unprocessable entity"),
    TOO_MANY_REQUESTS(429,"too many requests"),
    INTERNAL_SERVER_ERROR(500,"internal server error"),
    NOT_IMPLEMENTED(501,"not implemented");
    //
    private String description;
    private Integer number;
    //

    ResponseStatusEnum( Integer number,String description) {
        this.description = description;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
