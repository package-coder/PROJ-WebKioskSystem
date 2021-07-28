package com.company.interfaces;

public interface AuthManager {
    boolean authenticate(String identification, String type, String password);
}
