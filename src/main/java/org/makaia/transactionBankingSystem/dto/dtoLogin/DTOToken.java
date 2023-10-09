package org.makaia.transactionBankingSystem.dto.dtoLogin;

public class DTOToken {

    private String jwtToken;

    public DTOToken() {
    }

    public DTOToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
