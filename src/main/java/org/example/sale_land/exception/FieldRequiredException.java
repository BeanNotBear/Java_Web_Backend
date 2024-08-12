package org.example.sale_land.exception;

public class FieldRequiredException extends RuntimeException{
    private static final long serialVersionUID = 1;
    public FieldRequiredException(String message) {
        super(message);
    }
}
