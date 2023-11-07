package com.nova.aathif.taxibooking.common;

public class AccessDeniedExcption extends RuntimeException{
    public AccessDeniedExcption(String message){
        super(message);
    }
}
