package org.makaia.transactionBankingSystem.dto.dtoLogin;

import org.makaia.transactionBankingSystem.model.Person;

public class DTOLogin {
    private String userName;
    private String password;

    public DTOLogin() {
    }

    public DTOLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
