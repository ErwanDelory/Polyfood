package org.polytech.polyfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String args[])  {
        System.out.println("Hello");
        String url="jdbc:mysql://localhost:3308/polyfood?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        String user="root";
        String password="";

        //String url="jdbc:mysql://database-1.cbfckhgdcm22.eu-west-3.rds.amazonaws.com/USERNAMEDATABASE";
        //String user="root";
        //String password="polytech";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql="INSERT INTO USERS VALUES ('erwan','erwan')";
            //Création de la connexion
            connection.createStatement().execute(sql);
            //Fermeture de la connexion
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } ;
    }
}