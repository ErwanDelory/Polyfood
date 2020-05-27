package org.polytech.polyfood.persistence;

import org.polytech.polyfood.business.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findByConsumerId(Long consumerId);
}
