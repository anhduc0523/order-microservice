package com.anhduc0523.microservices.inventory_.service;

import com.anhduc0523.microservices.inventory_.model.Inventory;
import com.anhduc0523.microservices.inventory_.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    public void addQuantityInventory(String skuCode, Integer quantity) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode);
        if (inventory == null) {
            throw new RuntimeException("Inventory not found for skuCode: " + skuCode);
        }
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryRepository.save(inventory);
    }

    public void decreaseQuantityInventory(String skuCode, Integer quantity) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode);

        if (inventory == null) {
            throw new RuntimeException("Inventory not found for skuCode: " + skuCode);
        }

        if (inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
        } else {
            throw new IllegalArgumentException("Not enough inventory for SKU: " + skuCode);
        }
    }
}
