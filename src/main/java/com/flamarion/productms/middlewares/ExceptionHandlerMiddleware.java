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
        HttpException httpException = HttpException.parse(exception);
        ErrorResponse errorResponse = ErrorResponse.builder().message(httpException.getMessage()).build();

        return ResponseEntity.status(httpException.getStatus()).body(errorResponse);
    }
}
