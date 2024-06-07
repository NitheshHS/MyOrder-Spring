package com.myapp.BookingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String message;
    @CreationTimestamp
    private LocalDateTime timeStamp;
    private String httpStatus;
}
