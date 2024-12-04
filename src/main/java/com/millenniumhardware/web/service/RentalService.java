package com.millenniumhardware.web.service;

import com.millenniumhardware.web.dto.RentalDTO;

import java.util.List;

public interface RentalService {
    RentalDTO create(RentalDTO rentalDTO);
    RentalDTO getById(String id);
    List<RentalDTO> getAll();
    RentalDTO update(String id, RentalDTO rentalDTO);
    void delete(String id);
}
