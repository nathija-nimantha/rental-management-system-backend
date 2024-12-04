package com.millenniumhardware.web.controller;

import com.millenniumhardware.web.dto.RentalDTO;
import com.millenniumhardware.web.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalDTO> createRental(@RequestBody RentalDTO rentalDTO) {
        RentalDTO createdRental = rentalService.create(rentalDTO);
        return ResponseEntity.ok(createdRental);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRental(@PathVariable String id) {
        RentalDTO rental = rentalService.getById(id);
        return ResponseEntity.ok(rental);
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        List<RentalDTO> rentals = rentalService.getAll();
        return ResponseEntity.ok(rentals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> updateRental(@PathVariable String id, @RequestBody RentalDTO rentalDTO) {
        RentalDTO updatedRental = rentalService.update(id, rentalDTO);
        return ResponseEntity.ok(updatedRental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable String id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}