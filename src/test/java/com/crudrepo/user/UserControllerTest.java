package com.crudrepo.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@SpringBootTest
public class UserControllerTest {
    HttpClient httpClient = HttpClient.newHttpClient();

    @Test
    public void shouldGetUser() {
    }
}
