package com.millenniumhardware.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "hardware_item")
public class HardwareItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String itemAvailability;
    private double rentalPerDay;
    private double finePerDay;

    @OneToMany(mappedBy = "hardwareItem", cascade = CascadeType.ALL)
    private List<RentalDetail> rentalDetails;
}
