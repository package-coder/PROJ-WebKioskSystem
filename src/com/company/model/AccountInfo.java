package com.company.model;

public class AccountInfo {
    private final String accountId;
    private final AccountTypes accountType;

    public AccountInfo(String accountId, AccountTypes accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }
}
