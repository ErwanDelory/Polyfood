package org.polytech.polyfood;


import org.polytech.polyfood.business.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello");
        /*String url="jdbc:mysql://localhost:3308/polyfood?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        String user="root"; // Login de la base de données
        String password=""; // Mot de passe de la base de données

        //Autre méthode de connexion sur une base de données en ligne
        //String url="jdbc:mysql://database-1.cbfckhgdcm22.eu-west-3.rds.amazonaws.com/USERNAMEDATABASE";
        //String user="root";
        //String password="polytech";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //String sql="INSERT INTO USERS VALUES ('erwan','erwan')";
            String sql = "SELECT * FROM USERS";
            //Création de la connexion
            // execute --> update, delete, insert
            // executeQuery --> select
            connection.createStatement().executeQuery(sql);

            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while(resultSet.next()) {
                System.out.println("username:" + resultSet.getString("username") + " password:" + resultSet.getString("password"));
            }

            //Fermeture de la connexion
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }; */

       OrderService orderService = new OrderService();

        Long consumerId = 982738L;
        Long restaurantId = 62937L;
        OrderLineItem item1 = new OrderLineItem(9L, "Salade papaye thaïlandaise", BigDecimal.valueOf(8.9));
        OrderLineItem item2 = new OrderLineItem(9L, "Fruits", BigDecimal.valueOf(5.9));
        OrderLineItem item3 = new OrderLineItem(9L, "Evian", BigDecimal.valueOf(2.5));
        List<OrderLineItem> orderLineItems = Arrays.asList(item1, item2, item3);

        DeliveryInformation deliveryInformation = new DeliveryInformation("33 Rue la Fayette","75009","DC 6382");

        PaymentInformation paymentInformation = new PaymentInformation("826786839822809","02/2022","762");

        Order order = new Order(consumerId, restaurantId, orderLineItems, deliveryInformation, paymentInformation);
        orderService.createOrder(order);


    }
}
