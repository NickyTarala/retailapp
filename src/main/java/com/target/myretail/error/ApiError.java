package com.target.myretail.error;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiError implements Serializable {
    private String errorCode;
    private String error;
    private String message;

    public ApiError(String error, String message){
        this.error=error;
        this.message=message;
    }

    public ApiError(String errorCode, String error, String message){
        this.errorCode = errorCode;
        this.error=error;
        this.message=message;
    }
}
