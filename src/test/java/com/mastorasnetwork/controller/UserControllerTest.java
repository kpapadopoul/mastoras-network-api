package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.User;
import com.mastorasnetwork.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void list() {

    }

    @Test
    void create() {
    }

    @Test
    void get() {

        User expectedUser = new User();
        expectedUser.setId(1L);

        Optional<User> userOptional = Optional.of(expectedUser);
        when(userRepository.findById(1L)).thenReturn(userOptional);

        User user = userController.get(1L);

        verify(userRepository).findById(1L);
        assertThat(user.getId(), is(1L));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}