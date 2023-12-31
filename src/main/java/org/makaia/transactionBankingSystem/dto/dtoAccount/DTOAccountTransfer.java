package org.makaia.transactionBankingSystem.dto.dtoAccount;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(title = "DTOAccountTransfer: Objeto de transferencia de datos" +
        " para la transferencia desde una cuenta bancaria a otra, contiene " +
        "la información los números de cuenta bancaria de origen y " +
        "destino y  la cantidad a transferir")
public class DTOAccountTransfer {
    private Long sourceAccountNumber;
    private Long destinationAccountNumber;
    private BigDecimal amount;

    public DTOAccountTransfer() {
    }


    public DTOAccountTransfer(Long sourceAccountNumber, Long destinationAccountNumber, BigDecimal amount) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
    }

    public Long getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(Long sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public Long getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(Long destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
