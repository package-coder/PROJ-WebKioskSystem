package com.company.controller;

import com.company.helpers.LoginAuthManager;
import com.company.helpers.PasswordHashable;
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
        while (isRunning()){
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

    }

    private boolean isRunning(){
        return true;
    }

}
