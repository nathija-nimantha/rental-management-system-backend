package com.millenniumhardware.web.service.impl;

import com.millenniumhardware.web.dto.RentalDTO;
import com.millenniumhardware.web.entity.Rental;
import com.millenniumhardware.web.repository.RentalRepository;
import com.millenniumhardware.web.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RentalDTO create(RentalDTO rentalDTO) {
        Rental rental = modelMapper.map(rentalDTO, Rental.class);
        Rental savedRental = rentalRepository.save(rental);
        return modelMapper.map(savedRental, RentalDTO.class);
    }

    @Override
    public RentalDTO getById(String id) {
        Rental rental = rentalRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Rental not found with ID: " + id));
        return modelMapper.map(rental, RentalDTO.class);
    }

    @Override
    public List<RentalDTO> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream()
                .map(rental -> modelMapper.map(rental, RentalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentalDTO update(String id, RentalDTO rentalDTO) {
        if (!rentalRepository.existsById(Integer.valueOf(id))) {
            throw new RuntimeException("Rental not found with ID: " + id);
        }
        Rental rental = modelMapper.map(rentalDTO, Rental.class);
        rental.setRentalId(Integer.parseInt(id));
        Rental updatedRental = rentalRepository.save(rental);
        return modelMapper.map(updatedRental, RentalDTO.class);
    }

    @Override
    public void delete(String id) {
        if (!rentalRepository.existsById(Integer.valueOf(id))) {
            throw new RuntimeException("Rental not found with ID: " + id);
        }
        rentalRepository.deleteById(Integer.valueOf(id));
    }
}
