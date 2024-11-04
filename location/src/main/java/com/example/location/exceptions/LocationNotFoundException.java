package com.example.location.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String message){
        super(message);
    }
}
