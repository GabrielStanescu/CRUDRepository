package com.crudrepo.user;

import com.crudrepo.helper.HttpHelper;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    @Test
    public void shouldGetUser() {
        User user = requestUserWithId(1);
        assertEquals(user, new User(1, "Gabriel", "ln", (short) 21, "email", "pass", new ArrayList<>()));
    }

    @Test
    public void shouldCreateUser() {
        User bodyUser = new User(500, "FirstName", "ln", (short) 31, "mail", "123", new ArrayList<>());
        HttpRequest postRequest = HttpHelper.createPostRequest("http://localhost:8082/users", bodyUser);
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(200, response.statusCode(), "failed to create user");
    }

    @Test
    public void shouldGetInitials() {
        HttpRequest httpRequest = HttpHelper.createGetRequest("http://localhost:8082/users/streams/initials");
        String responseBody = "";
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        List<String> initials = gson.fromJson(responseBody, ArrayList.class);
        assertEquals(161, initials.size(), "failed to get initials");
    }

    @Test
    public void shouldGetGmailUsers() {
        HttpRequest httpRequest = HttpHelper.createGetRequest("http://localhost:8082/users/streams/gmails");
        String responseBody = "";
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        Long noOfGmail = gson.fromJson(responseBody, Long.class);
        assertEquals(2, noOfGmail, "failed to get gmail users");
    }

    public User requestUserWithId(Integer id) {
        HttpRequest httpRequest = HttpHelper.createGetRequest("http://localhost:8082/users/" + id);
        String responseBody = "";
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return gson.fromJson(responseBody, User.class);
    }

}
