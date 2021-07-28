package com.company.helpers;

import com.company.interfaces.AuthManager;
import com.company.interfaces.Hashable;

import java.sql.SQLException;
import java.util.Arrays;
import java.sql.Connection;

public class LoginAuthManager implements AuthManager {
    private final Connection connection;
    private final Hashable hashable;

    public LoginAuthManager(Connection connection, Hashable hashable) {
        this.connection = connection;
        this.hashable = hashable;
        if (connection == null)
            throw new IllegalArgumentException();
    }

    @Override
    public boolean authenticate(String identification, String type, String password) {

        var credentials = getCredentials(identification, type);

        if(credentials == null)
            return false;

        var hashedPassword = credentials[0];
        var salt = credentials[1];

        var hash = hashable.hash(password.toCharArray(), salt);
        return Arrays.equals(hashedPassword, hash);
    }

    private byte[][] getCredentials(String identification, String type){

        final var credentials = new byte[2][];

        var sql = """
                  SELECT password, salt
                  FROM accounts
                  WHERE accountId = ? AND accountType = ?;
                  """;

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, identification);
            preparedStatement.setString(2, type);

            var resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                var password = resultSet.getBytes("password");
                var salt = resultSet.getBytes("salt");

                credentials[0] = password;
                credentials[1] = salt;

                return credentials;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
