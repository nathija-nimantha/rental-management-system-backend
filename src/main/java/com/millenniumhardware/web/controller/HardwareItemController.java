package com.millenniumhardware.web.controller;

import com.millenniumhardware.web.dto.HardwareItemDTO;
import com.millenniumhardware.web.service.HardwareItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class HardwareItemController {

    @Autowired
    private HardwareItemService hardwareItemService;

    @PostMapping
    public ResponseEntity<HardwareItemDTO> createHardwareItem(@RequestBody HardwareItemDTO hardwareItemDTO) {
        HardwareItemDTO createdItem = hardwareItemService.create(hardwareItemDTO);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardwareItemDTO> getHardwareItem(@PathVariable Integer id) {
        HardwareItemDTO hardwareItem = hardwareItemService.getById(id);
        return ResponseEntity.ok(hardwareItem);
    }

    @GetMapping
    public ResponseEntity<List<HardwareItemDTO>> getAllHardwareItems() {
        List<HardwareItemDTO> hardwareItems = hardwareItemService.getAll();
        return ResponseEntity.ok(hardwareItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardwareItemDTO> updateHardwareItem(@PathVariable Integer id, @RequestBody HardwareItemDTO hardwareItemDTO) {
        HardwareItemDTO updatedItem = hardwareItemService.update(id, hardwareItemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardwareItem(@PathVariable Integer id) {
        hardwareItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
