package com.energy_backend.energy_api.exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException(String message,Throwable cause) {
        super(message,cause);
    }
}
