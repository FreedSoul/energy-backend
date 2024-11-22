package com.energy_backend.energy_api.exceptions;

public class DatabaseOperationException extends RuntimeException {
  public DatabaseOperationException(String message, Throwable cause) {
    super(message,cause);
  }
}
