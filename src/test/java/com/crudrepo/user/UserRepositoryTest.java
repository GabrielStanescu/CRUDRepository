package com.crudrepo.user;

import com.crudrepo.user.model.User;
import com.crudrepo.user.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UserRepository.class)
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @MockBean(name = "userRepository")
    private UserRepository userRepository;

    @Test
    public void shouldFindByName() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Gabriel", "Stanescu", (short) 21, "test", "test", null));
        userList.add(new User(2, "Gabriel", "Gabi", (short) 20, "email", "pass", null));
        Mockito.when(userRepository.findByFirstName("Gabriel")).thenReturn(userList);
        assertEquals(2, userRepository.findByFirstName("Gabriel").size(), "invalid list size");
        assertEquals("Gabriel", userRepository.findByFirstName("Gabriel").get(0).getFirstName(), "find by first name failed.");
        assertEquals("Gabriel", userRepository.findByFirstName("Gabriel").get(1).getFirstName(), "find by first name failed.");
    }
}
