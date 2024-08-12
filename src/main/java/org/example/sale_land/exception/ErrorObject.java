package org.example.sale_land.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

@Getter
@Builder
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private final Date timestamp = new Date();
}
