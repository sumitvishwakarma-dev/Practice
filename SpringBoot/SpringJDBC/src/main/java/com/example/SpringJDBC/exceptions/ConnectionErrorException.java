package com.example.SpringJDBC.exceptions;

public class ConnectionErrorException extends RuntimeException{

    public ConnectionErrorException(String message){
        super(message);
    }
}
