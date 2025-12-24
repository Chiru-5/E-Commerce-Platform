package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer_Id(Long customerId); // 4

    List<Order> findByStatus(OrderStatus status); // 5

    @Query("SELECT MONTH(o.orderDate), COUNT(o) FROM Order o GROUP BY MONTH(o.orderDate)")
    List<Object[]> monthlyOrders(); // 6
}