package org.example.sale_land.exception;

public class NotFoundBuildingException extends RuntimeException{

    private static final long serialVersionUID = 1;
    public NotFoundBuildingException(String message) {
        super(message);
    }
}
