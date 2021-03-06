package org.polytech.polyfood.persistence;

import org.polytech.polyfood.business.DeliveryInformation;
import org.polytech.polyfood.business.Order;
import org.polytech.polyfood.business.OrderLineItem;
import org.polytech.polyfood.business.PaymentInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JdbcOrderRepository {

    public void save(Order order) {
        String url="jdbc:mysql://localhost:3308/polyfood?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        String username="root";
        String password="";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            DeliveryInformation deliveryInformation = order.getDeliveryInformation();
            PaymentInformation paymentInformation = order.getPaymentInformation();
            String sql = "INSERT INTO T_ORDER (CONSUMER_ID,RESTAURANT_ID,ADDRESS,ZIP_CODE,DETAILS,CREDIT_CARD,END_DATE,SECURITY_CODE)" +
                    " VALUES("
                    + order.getConsumerId() + ","
                    + order.getRestaurantId() + ","
                    + sqlValueString(deliveryInformation.getAddress()) + ","
                    + sqlValueString(deliveryInformation.getZipCode()) + ","
                    + sqlValueString(deliveryInformation.getDetails()) + ","
                    + sqlValueString(paymentInformation.getCreditCard()) + ","
                    + sqlValueString(paymentInformation.getEndDate()) + ","
                    + sqlValueString(paymentInformation.getSecurityCode())
                    + ")";
            connection.createStatement().execute(sql);

            for (OrderLineItem orderLineItem : order.getOrderLineItems()) {
                String sql2 = "INSERT INTO T_ORDER_LINE_ITEM VALUES(" +
                        "LAST_INSERT_ID()" + ","
                        + orderLineItem.getMenuId() + ","
                        + sqlValueString(orderLineItem.getName()) + ","
                        + orderLineItem.getPrice()
                        + ")";
                connection.createStatement().execute(sql2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String sqlValueString(String string) {
        return "'" + string + "'";
    }

    public List<Order> findByConsumerId(Long consumerId) {
        return null;
    }
}
