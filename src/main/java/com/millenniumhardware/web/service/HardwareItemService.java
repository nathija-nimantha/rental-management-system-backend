package com.millenniumhardware.web.service;

import com.millenniumhardware.web.dto.HardwareItemDTO;

import java.util.List;

public interface HardwareItemService {
    HardwareItemDTO create(HardwareItemDTO hardwareItemDTO);
    HardwareItemDTO getById(Integer id);
    List<HardwareItemDTO> getAll();
    HardwareItemDTO update(Integer id, HardwareItemDTO hardwareItemDTO);
    void delete(Integer id);
}
