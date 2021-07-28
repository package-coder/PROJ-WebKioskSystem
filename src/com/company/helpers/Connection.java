package com.company.helpers;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = "jdbc:sqlite:database.sqlite";

    public static java.sql.Connection get(){

        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
