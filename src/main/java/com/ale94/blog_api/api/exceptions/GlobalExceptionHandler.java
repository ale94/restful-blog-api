package com.ale94.blog_api.api.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerResourceNotFoundException(ResourceNotFoundException ex,
        WebRequest request) {
        ErrorDTO error = new ErrorDTO(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
    }

    // validacion
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handlerMethodArgumentNotValidException(
//        MethodArgumentNotValidException ex, WebRequest request) {
//        Map<String, Object> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors()
//            .forEach(err -> {
//                errors.put(err.getField(),
//                    "El campo " + err.getField() + " " + err.getDefaultMessage());
//            });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
