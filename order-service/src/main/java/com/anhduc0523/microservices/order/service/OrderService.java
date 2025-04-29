package com.anhduc0523.microservices.order.service;

import com.anhduc0523.microservices.order.client.InventoryClient;
import com.anhduc0523.microservices.order.dto.OrderRequest;
import com.anhduc0523.microservices.order.model.Order;
import com.anhduc0523.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        boolean isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        // Check if the inventory is in stock
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());

            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() +" is not in stock");
        }

    }

    public void updateOrder(String id, OrderRequest orderRequest) {
        Order order = orderRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }
}
