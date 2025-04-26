package com.anhduc0523.microservices.inventory_.repository;

import com.anhduc0523.microservices.inventory_.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

    Inventory findBySkuCode(String skuCode);
}
