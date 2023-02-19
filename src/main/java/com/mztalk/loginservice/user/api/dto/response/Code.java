package com.mztalk.loginservice.user.api.dto.response;

public enum Code {

    SUCCESS(1) , FAIL(-1);

    private final Integer code;

    Code(Integer code) {this.code = code;}

    public Integer getCode(){return code;}
}
