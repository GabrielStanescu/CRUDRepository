package com.crudrepo.account;

import com.google.gson.Gson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.http.HttpClient;

@SpringBootTest
@ActiveProfiles("test")
public class AccountControllerTest {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();

}
