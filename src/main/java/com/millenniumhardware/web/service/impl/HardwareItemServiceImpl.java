package com.millenniumhardware.web.service.impl;

import com.millenniumhardware.web.dto.HardwareItemDTO;
import com.millenniumhardware.web.entity.HardwareItem;
import com.millenniumhardware.web.repository.HardwareItemRepository;
import com.millenniumhardware.web.service.HardwareItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardwareItemServiceImpl implements HardwareItemService {

    @Autowired
    private HardwareItemRepository hardwareItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HardwareItemDTO create(HardwareItemDTO hardwareItemDTO) {
        HardwareItem hardwareItem = modelMapper.map(hardwareItemDTO, HardwareItem.class);
        HardwareItem savedItem = hardwareItemRepository.save(hardwareItem);
        return modelMapper.map(savedItem, HardwareItemDTO.class);
    }

    @Override
    public HardwareItemDTO getById(Integer id) {
        HardwareItem hardwareItem = hardwareItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hardware item not found with ID: " + id));
        return modelMapper.map(hardwareItem, HardwareItemDTO.class);
    }

    @Override
    public List<HardwareItemDTO> getAll() {
        List<HardwareItem> hardwareItems = hardwareItemRepository.findAll();
        return hardwareItems.stream()
                .map(item -> modelMapper.map(item, HardwareItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HardwareItemDTO update(Integer id, HardwareItemDTO hardwareItemDTO) {
        if (!hardwareItemRepository.existsById(id)) {
            throw new RuntimeException("Hardware item not found with ID: " + id);
        }
        HardwareItem hardwareItem = modelMapper.map(hardwareItemDTO, HardwareItem.class);
        hardwareItem.setItemId(id); // Ensure the ID is retained
        HardwareItem updatedItem = hardwareItemRepository.save(hardwareItem);
        return modelMapper.map(updatedItem, HardwareItemDTO.class);
    }

    @Override
    public void delete(Integer id) {
        if (!hardwareItemRepository.existsById(id)) {
            throw new RuntimeException("Hardware item not found with ID: " + id);
        }
        hardwareItemRepository.deleteById(id);
    }
}
