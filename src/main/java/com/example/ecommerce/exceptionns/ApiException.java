package com.example.ecommerce.exceptionns;

public class ApiException extends RuntimeException{
    private static final long serialVersionUUID = 1L;
    public ApiException(){

    }
    public ApiException(String message){
        super(message);
    }

}
