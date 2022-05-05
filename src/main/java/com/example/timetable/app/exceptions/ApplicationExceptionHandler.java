package com.example.timetable.app.exceptions;

import com.example.timetable.app.jwt.JwtResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
           // errorMap.put("message " , error.getDefaultMessage());
            errorMap.put(error.getField(), error.getDefaultMessage());
           // errorMap.put("error " , String.valueOf(HttpStatus.BAD_REQUEST));
        });

     return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);


    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleBusinessException(UserNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage ", ex.getMessage());
        return (Map<String, String>) new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<JwtResponse> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request){
        return ResponseEntity.status(403).body(new JwtResponse(e.getMessage()));
    }

}