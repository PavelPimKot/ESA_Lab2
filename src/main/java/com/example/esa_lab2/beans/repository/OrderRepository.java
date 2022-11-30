package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Order;

import java.util.List;

public interface OrderRepository extends Repository {
    List<Order> getOrdersForAdmin();

    List<Order> getOrdersForClient(Integer clientId);

    List<Order> getOrdersByUserId(Integer userId);

    Order findOrderById(Integer orderId);
}
