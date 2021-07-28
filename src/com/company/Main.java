package com.company;

import com.company.controller.WebKioskApp;
import com.company.helpers.ConcreteStudentDAO;
import com.company.helpers.Connection;
import com.company.helpers.LoginAuthManager;
import com.company.helpers.PasswordHashable;
import com.company.view.WebKioskView;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        var hashable = new PasswordHashable();
//        var salt = hashable.generateSalt();
//        var hash = hashable.hash("password".toCharArray(), salt);
//
//        var sql = """
//                  INSERT INTO accounts (accountId, password, salt, accountType)
//                  VALUES (?, ?, ?, ?);
//                  """;
//
//        var connection = Connection.get();
//        try {
//            var preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "123-123");
//            preparedStatement.setBytes(2, hash);
//            preparedStatement.setBytes(3, salt);
//            preparedStatement.setString(4, "type");
//
//            var resultSet = preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        var manager = new LoginAuthManager(Connection.get(), new PasswordHashable());
//        var isAuthenticated= manager.authenticate("123-123", "type", "password");
//        System.out.println(isAuthenticated);

        var connection = Connection.get();
        var app = new WebKioskApp(connection);
        app.run();
    }

}
