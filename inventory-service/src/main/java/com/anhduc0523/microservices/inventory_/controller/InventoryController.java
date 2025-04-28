package com.anhduc0523.microservices.inventory_.controller;

import com.anhduc0523.microservices.inventory_.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addQuantityInventory(@RequestParam String skuCode, @RequestParam Integer quantity) {
        inventoryService.addQuantityInventory(skuCode, quantity);
    }

    @PutMapping("/decrement")
    @ResponseStatus(HttpStatus.OK)
    public void decrementInventory(@RequestParam String skuCode, @RequestParam Integer quantity) {
        inventoryService.decreaseQuantityInventory(skuCode, quantity);
    }
}
