package com.company.controller;

import com.company.helpers.*;
import com.company.model.AccountInfo;
import com.company.view.WebKioskView;

import java.sql.Connection;

public class WebKioskApp {
    private final Connection connection;
    private AccountInfo accountInfo;


    public WebKioskApp(Connection connection) {
        this.connection = connection;
    }

    public void run(){
        while (WebKioskView.isRunning()){
            authenticate();
            dashboard();
        }
    }

    private void authenticate(){
        final var passwordHashable = new PasswordHashable();
        final var authenticator = new LoginAuthManager(connection, passwordHashable);
        accountInfo = WebKioskView.login(authenticator);
    }

    private void dashboard(){

        var dao = switch (accountInfo.getAccountType()){
            case STUDENT -> new ConcreteStudentDAO(connection);
            case PARENT -> new ConcreteParentDAO(connection);
            case FACULTY -> new ConcreteFacultyDAO(connection);
        };

        WebKioskView.dashboard(accountInfo,
                new ConcreteUpdateAccountPassword(accountInfo.getAccountId(), connection),
                dao,
                new LoginAuthManager(connection, new PasswordHashable()));
    }
    
}
