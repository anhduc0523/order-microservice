package com.anhduc0523.microservices.order.controller;

import com.anhduc0523.microservices.order.dto.OrderRequest;
import com.anhduc0523.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        
        return "Order placed successfully";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateOrder(@PathVariable String id, @RequestBody OrderRequest orderRequest) {
        orderService.updateOrder(id, orderRequest);

        return "Order updated successfully";
    }
}
