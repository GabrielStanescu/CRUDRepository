package com.crudrepo.user;

import com.crudrepo.user.model.Account;
import com.crudrepo.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestParam("id") Integer id, @RequestParam("currency") String currency) {
        if(accountService.createAccount(id, currency))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT); // bruh what's this
    }

    @GetMapping("/{id}")
    public List<Account> getAccounts(@PathVariable Integer id) {
        return accountService.getAccounts(id);
    }
}
