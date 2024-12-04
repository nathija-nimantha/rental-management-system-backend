package com.millenniumhardware.web.repository;

import com.millenniumhardware.web.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
