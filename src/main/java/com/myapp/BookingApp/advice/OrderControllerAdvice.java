package com.myapp.BookingApp.advice;

import com.myapp.BookingApp.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponseDTO> handleExceptions(RuntimeException exception){
        ErrorResponseDTO responseDTO=new ErrorResponseDTO();
        responseDTO.setHttpStatus(HttpStatus.NOT_FOUND.name());
        responseDTO.setTimeStamp(LocalDateTime.now());
        responseDTO.setMessage(exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
