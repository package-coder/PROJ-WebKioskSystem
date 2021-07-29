package com.company.helpers;

import com.company.interfaces.UpdateObjectDAO;
import com.company.interfaces.UpdatePasswordDAO;

import java.sql.Connection;

public class ConcreteUpdateAccountPassword implements UpdatePasswordDAO {
    private String accountId;
    private Connection connection;

    public ConcreteUpdateAccountPassword(String accountId, Connection connection) {
        this.accountId = accountId;
        this.connection = connection;
    }

    @Override
    public void update(Byte[] object) {

    }
}
