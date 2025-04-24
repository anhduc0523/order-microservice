package com.anhduc0523.microservices.order.repository;

import com.anhduc0523.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
