package org.polytech.polyfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String args[])  {
        System.out.println("Hello");
        String url="jdbc:mysql://localhost:3308/polyfood?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
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
        } ;
    }
}