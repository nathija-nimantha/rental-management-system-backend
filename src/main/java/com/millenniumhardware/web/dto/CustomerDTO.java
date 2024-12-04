package com.millenniumhardware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerCity;
    private String customerContact;
}
