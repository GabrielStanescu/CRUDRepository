package com.crudrepo.user;

import com.crudrepo.user.model.User;
import com.crudrepo.user.service.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(classes = UserRepository.class)
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @MockBean
    UserRepository userRepository;

    @Test
    public void shouldFindByName() {
        Optional<User> userOptional = Optional.of(new User());
    }
}
