package org.makaia.transactionBankingSystem.service;

import org.junit.jupiter.api.Test;
import org.makaia.transactionBankingSystem.dto.dtoPocket.DTOPocketConsultIn;
import org.makaia.transactionBankingSystem.dto.dtoPocket.DTOPocketCreation;
import org.makaia.transactionBankingSystem.exception.ApiException;
import org.makaia.transactionBankingSystem.model.Account;
import org.makaia.transactionBankingSystem.model.Person;
import org.makaia.transactionBankingSystem.model.Pocket;
import org.makaia.transactionBankingSystem.repository.AccountRepository;
import org.makaia.transactionBankingSystem.repository.PocketRepository;
import org.makaia.transactionBankingSystem.validation.PocketValidation;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PocketServiceTest {

    PocketRepository pocketRepository = Mockito.mock(PocketRepository.class);
    PocketValidation pocketValidation = Mockito.mock(PocketValidation.class);
    AccountService accountService = Mockito.mock(AccountService.class);

    PocketService pocketService = new PocketService(pocketRepository,
            pocketValidation, accountService);

    @Test
    void getPocketsByAccountNumber() {
        Long accountNumber = 333908555109438L;
        Person person = new Person("1020475585", "Yeisson", "Vahos", "+57" +
                "-3046406015", "yvahosc@gmail.com");
        Account account = new Account(accountNumber, BigDecimal.valueOf(1000),
                person);
        Pocket pocket = new Pocket("Vacaciones", BigDecimal.valueOf(1000), account);
        List<Pocket> pockets = List.of(pocket);
        Mockito.when(pocketRepository.findByAccountAccountNumber(accountNumber)).thenReturn(pockets);

        assertEquals(1,
                pocketService.getPocketsByAccountNumber(accountNumber).getPockets().size());
    }

    @Test
    void createPocketWithNonExistingAccount() throws ApiException {
        Long accountNumber = 333908555109438L;
        DTOPocketCreation dtoPocketCreation =
                new DTOPocketCreation(accountNumber, "Vacaciones",
                        BigDecimal.valueOf(1000));

        Mockito.when(pocketValidation.createPocketValidation(dtoPocketCreation)).thenReturn(true);
        Mockito.when(accountService.getAccountById(accountNumber)).thenReturn(null);
        ApiException apiException = assertThrows(ApiException.class,
                () -> pocketService.createPocket(dtoPocketCreation));
        assertEquals(404, apiException.getStatusCode());
        assertEquals(List.of("La cuenta con numero '" + dtoPocketCreation.getAccountNumber() +
                        "' no existe en la base de datos."),
                apiException.getErrors());
    }



    @Test
    void transferToPocket() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void balanceInPocketsOfOneAccount() {
    }
}