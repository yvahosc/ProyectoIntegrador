package org.makaia.transactionBankingSystem.dto.dtoPerson;

import org.makaia.transactionBankingSystem.model.Person;


public class DTOPersonCreate {

    private Person person;
    private String password;

    public DTOPersonCreate() {
    }

    public DTOPersonCreate(Person person, String password) {
        this.person = person;
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
