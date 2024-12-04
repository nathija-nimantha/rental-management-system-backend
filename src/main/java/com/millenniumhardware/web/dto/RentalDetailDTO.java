package com.millenniumhardware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalDetailDTO {
    private int detailId;
    private int qty;
    private double totalItemCost;
}