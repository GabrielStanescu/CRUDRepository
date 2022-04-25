package com.crudrepo.user;

import com.crudrepo.user.exceptions.InvalidJWTException;
import com.crudrepo.user.model.Account;
import com.crudrepo.user.model.JWTRequest;
import com.crudrepo.user.model.JWTResponse;
import com.crudrepo.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestHeader(name = "Authorization") JWTResponse jwtResponse,
                                           @RequestHeader(name = "currency") String currency,
                                           @RequestHeader(name = "prefix") String prefix) throws NoSuchAlgorithmException, InvalidKeyException, InvalidJWTException {
        if (prefix.length() != 2)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        int id = accountService.getUserIdFromJwt(jwtResponse);
        prefix = prefix.toUpperCase();
        if(accountService.createAccount(id, currency, prefix))
            return new ResponseEntity<>("Account created for user with id " + id, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT); // bruh what's this
    }

    @GetMapping("/{id}")
    public List<Account> getAccounts(@PathVariable Integer id) {
        return accountService.getAccounts(id);
    }
}
