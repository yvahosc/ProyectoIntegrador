package org.makaia.transactionBankingSystem.controller;

import org.makaia.transactionBankingSystem.dto.dtoPocket.DTOPocketConsultOut;
import org.makaia.transactionBankingSystem.dto.dtoPocket.DTOPocketCreation;
import org.makaia.transactionBankingSystem.dto.dtoPocket.DTOPocketTransfer;
import org.makaia.transactionBankingSystem.exception.ApiException;
import org.makaia.transactionBankingSystem.service.AccountService;
import org.makaia.transactionBankingSystem.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/pockets")
public class PocketController {

    PocketService pocketService;
    AccountService accountService;

    @Autowired
    public PocketController(PocketService pocketService, AccountService accountService){
        this.pocketService = pocketService;
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<DTOPocketConsultOut> getPockets (HttpServletRequest request, @PathVariable Long accountNumber) throws ApiException {
        this.accountService.isLoggedInUserTheOwnerOfTheAccount(accountNumber,
                request.getUserPrincipal().getName());
        return ResponseEntity.ok(this.pocketService.getPocketsByAccountNumber(accountNumber));
    }

    @PostMapping
    public ResponseEntity<DTOPocketCreation> createPocket(HttpServletRequest request, @RequestBody DTOPocketCreation dtoPocketCreation) throws ApiException {
        this.accountService.isLoggedInUserTheOwnerOfTheAccount(dtoPocketCreation.getAccountNumber(),
                request.getUserPrincipal().getName());
        System.out.println(dtoPocketCreation.getAccountNumber());
        return ResponseEntity.ok(this.pocketService.createPocket(dtoPocketCreation));
    }

    @PostMapping("/transfer")
    public ResponseEntity<DTOPocketTransfer> transferToPocket(HttpServletRequest request, @RequestBody DTOPocketTransfer dtoPocketTransfer) throws ApiException{
        this.accountService.isLoggedInUserTheOwnerOfTheAccount(dtoPocketTransfer.getAccountNumber(),
                request.getUserPrincipal().getName());
        return ResponseEntity.ok(this.pocketService.transferToPocket(dtoPocketTransfer));
    }
}
