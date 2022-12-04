package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.OrderRepository;
import com.example.esa_lab2.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "orderRepository")
@Transactional
public class OrderRepositoryImpl extends AbstractRepository implements OrderRepository {
    @Override
    public List<Order> getOrdersForAdmin() {
        return entityManager.createQuery(
                "select order from Order order where   order.isDeleted = false ", Order.class).getResultList();
    }

    @Override
    public List<Order> getOrdersForClient(Integer clientId) {
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", clientId).getResultList();
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", userId).getResultList();
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public List<Order> getOrders() {
        return entityManager.createQuery("select order from Order order where  order.isDeleted = false ", Order.class)
                .getResultList();
    }
}
