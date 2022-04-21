package com.crudrepo.account;

import com.crudrepo.user.model.Account;
import com.crudrepo.user.service.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AccountRepository.class)
@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {
    @MockBean
    AccountRepository accountRepository;

    @Test
    public void shouldGetByIban() {
        Optional<Account> accountOp = Optional.of(new Account());
        accountOp.get().setIBAN("RO12345678901234");
        Mockito.when(accountRepository.findByIBAN("RO12345678901234")).thenReturn(accountOp);
        assertEquals(accountOp, accountRepository.findByIBAN("RO12345678901234"), "failed to get account");
        assertEquals(accountOp.get().getIBAN(), accountRepository.findByIBAN("RO12345678901234").get().getIBAN(), "failed to get IBAN");
    }

    @Test
    public void shouldGetAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1, 1, "RON", "iban1", 100d));
        accountList.add(new Account(2, 1, "EUR", "iban2", 200d));
        accountList.add(new Account(3, 1, "USD", "iban3", 300d));
        Mockito.when(accountRepository.findAllByUserId(1)).thenReturn(accountList);
        assertEquals(3, accountRepository.findAllByUserId(1).size(), "invalid list size");
        assertEquals(accountList, accountRepository.findAllByUserId(1), "failed to get list");
    }
}
