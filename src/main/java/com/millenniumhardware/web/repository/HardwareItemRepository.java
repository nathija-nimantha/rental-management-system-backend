package com.millenniumhardware.web.repository;

import com.millenniumhardware.web.entity.HardwareItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareItemRepository extends JpaRepository<HardwareItem, Integer> {
}
