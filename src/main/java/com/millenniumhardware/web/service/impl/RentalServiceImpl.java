package com.millenniumhardware.web.service.impl;

import com.millenniumhardware.web.dto.RentalDTO;
import com.millenniumhardware.web.entity.Rental;
import com.millenniumhardware.web.exception.RentalNotFoundException;
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
        Rental rental = rentalRepository.findById(parseId(id))
                .orElseThrow(() -> new RentalNotFoundException("Rental not found with ID: " + id));
        return modelMapper.map(rental, RentalDTO.class);
    }

    @Override
    public List<RentalDTO> getAll() {
        return rentalRepository.findAll().stream()
                .map(rental -> modelMapper.map(rental, RentalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentalDTO update(String id, RentalDTO rentalDTO) {
        int rentalId = parseId(id);

        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found with ID: " + id));

        modelMapper.map(rentalDTO, rental);
        rental.setRentalId(rentalId);

        Rental updatedRental = rentalRepository.save(rental);
        return modelMapper.map(updatedRental, RentalDTO.class);
    }

    @Override
    public void delete(String id) {
        int rentalId = parseId(id);

        if (!rentalRepository.existsById(rentalId)) {
            throw new RentalNotFoundException("Rental not found with ID: " + id);
        }

        rentalRepository.deleteById(rentalId);
    }

    private int parseId(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid rental ID format: " + id);
        }
    }
}