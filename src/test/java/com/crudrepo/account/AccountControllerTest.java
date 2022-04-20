package com.crudrepo.account;

import com.crudrepo.helper.HttpHelper;
import com.crudrepo.user.model.Account;
import com.crudrepo.user.model.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class AccountControllerTest {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    @Test
    public void shouldGetAccount() {
        List<Account> accountList = requestUserWithId(1);
        Account account = new Account(1, 1, "RON", "DB09079714855445", 0);
        assertEquals(accountList.get(0).getBalance(), account.getBalance());
        assertEquals(accountList.get(0).getId(), account.getId());
        assertEquals(accountList.get(0).getUserId(), account.getUserId());
    }

    private List<Account> requestUserWithId(int id) {
        HttpRequest httpRequest = HttpHelper.createGetRequest("http://localhost:8082/accounts/" + id);
        String responseBody = "";
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // weird bug where any iban returned is null ???
        Account[] accounts = gson.fromJson(responseBody, Account[].class);
        return Arrays.asList(accounts);
    }
}
