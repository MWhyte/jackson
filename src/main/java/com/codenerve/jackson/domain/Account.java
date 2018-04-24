package com.codenerve.jackson.domain;

import java.util.Objects;

public class Account {

    private String accountId;
    private String accountName;

    private Account(){} // see part 1 for why this is needed!

    public Account(String accountId, String accountName) {
        this.accountId = accountId;
        this.accountName = accountName;
    }

    public String getAccountID() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
                Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName);
    }
}
