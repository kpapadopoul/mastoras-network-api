package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.User;
import com.mastorasnetwork.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        assertEquals(1L, user.getId().longValue());

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}