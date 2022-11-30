package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.OrderRepositoryImpl;
import com.example.esa_lab2.beans.service.OrderService;
import com.example.esa_lab2.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    private OrderRepositoryImpl orderRepository;

    @Override
    public List<Order> getOrdersForAdmin() {
        return orderRepository.getOrdersForAdmin();
    }

    @Override
    public List<Order> getOrdersForClient(Integer clientId) {
        return orderRepository.getOrdersForClient(clientId);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
