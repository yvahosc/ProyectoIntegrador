package org.makaia.transactionBankingSystem.dto.dtoAccount;

import org.makaia.transactionBankingSystem.dto.dtoPerson.DTOPersonCreate;
import org.makaia.transactionBankingSystem.model.Person;

import java.math.BigDecimal;

public class DTOAccountCreation {
    private DTOPersonCreate owner;
    private BigDecimal initialBalance;

    public DTOAccountCreation() {
    }

    public DTOAccountCreation(DTOPersonCreate owner, BigDecimal initialBalance) {
        this.owner = owner;
        this.initialBalance = initialBalance;
    }

    public DTOPersonCreate getOwner() {
        return owner;
    }

    public void setOwner(DTOPersonCreate owner) {
        this.owner = owner;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
