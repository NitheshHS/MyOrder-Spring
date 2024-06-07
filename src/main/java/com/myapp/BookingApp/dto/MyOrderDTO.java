package com.myapp.BookingApp.dto;

import com.myapp.BookingApp.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyOrderDTO {
    private String orderTracker;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private AddressDTO billingAddress;
}
