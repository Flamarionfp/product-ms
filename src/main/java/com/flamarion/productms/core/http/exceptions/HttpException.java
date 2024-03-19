package com.flamarion.productms.core.http.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException  {
    private final int status;

    public HttpException(HttpStatus status, String message) {
        super(message);
        this.status = status.value();
    }

    public static HttpException parse(Exception exception) {
        if (exception instanceof HttpException) return (HttpException) exception;

        return new HttpException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
