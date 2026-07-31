package com.sumitdev.student.exceptionhandler;

public class DuplicateResourceExceptionHandler extends RuntimeException{

    public DuplicateResourceExceptionHandler(String message){
        super(message);
    }
}
