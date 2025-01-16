package org.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex, WebRequest request){

        ErrorResponseDto error = ErrorResponseDto.builder().
                timestamp(OffsetDateTime.now()).
                code(HttpStatus.NOT_FOUND.value()).
                message(ex.getMessage()).
                detail(ex.getMessage()+" NOT FOUND").
                path(((ServletWebRequest) request).getRequest().getRequestURI()).
                build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
