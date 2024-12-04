package com.millenniumhardware.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rental_detail")
public class RentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;

    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "rentalId")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    private HardwareItem hardwareItem;

    private int qty;
    private double totalItemCost;
}

