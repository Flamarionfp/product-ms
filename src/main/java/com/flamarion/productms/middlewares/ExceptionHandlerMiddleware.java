package com.flamarion.productms.middlewares;

import com.flamarion.productms.core.http.exceptions.HttpException;
import com.flamarion.productms.models.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerMiddleware {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception exception) {
        HttpException parsedException = HttpException.parse(exception);
        ErrorResponse errorResponse = ErrorResponse.builder().message(parsedException.getMessage()).build();

        return ResponseEntity.status(parsedException.getStatus()).body(errorResponse);
    }
}
