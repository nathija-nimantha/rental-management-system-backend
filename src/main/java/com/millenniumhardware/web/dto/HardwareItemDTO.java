package com.millenniumhardware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HardwareItemDTO {
    private int itemId;
    private String itemName;
    private String itemAvailability;
    private double rentalPerDay;
    private double finePerDay;
}
