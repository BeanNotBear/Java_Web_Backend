package org.example.sale_land.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<ErrorObject> handleFieldRequiredException(
            FieldRequiredException ex,
            WebRequest request
    ) {
        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundBuildingException.class)
    public ResponseEntity<ErrorObject> handleNotFoundBuildingException(
            NotFoundBuildingException ex,
            WebRequest request
    ) {
        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }
}
