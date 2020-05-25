package org.polytech.polyfood.business;

import org.polytech.polyfood.persistence.JdbcOrderRepository;

public class OrderService {
    private JdbcOrderRepository jdbcOrderRepository = new JdbcOrderRepository();

    public void createOrder(Order order) {
        // verify consumer details
        // verify that restaurant is opened
        // ask restaurant to prepare this ticket
        // verify user paymentInformation
        // if all ok then save order in database
        this.jdbcOrderRepository.save(order);
        // send notification to user
    }
}
