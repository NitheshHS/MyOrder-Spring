package com.myapp.BookingApp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myapp.BookingApp.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyOrderDTO {
    private String orderTracker;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private AddressDTO billingAddress;
}
