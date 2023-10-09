package org.makaia.transactionBankingSystem.controller;

import org.makaia.transactionBankingSystem.dto.dtoLogin.DTOLogin;
import org.makaia.transactionBankingSystem.dto.dtoLogin.DTOToken;
import org.makaia.transactionBankingSystem.exception.ApiException;
import org.makaia.transactionBankingSystem.model.User;
import org.makaia.transactionBankingSystem.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    AuthenticationManager authenticationManager;
    TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody DTOLogin dtoLogin) throws ApiException {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoLogin.getUserName(), dtoLogin.getPassword());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DTOToken(JWTToken));
    }
}
