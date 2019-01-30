package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.User;
import com.mastorasnetwork.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.doAnswer;
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

        final List<User> expectedUsers = prepareUsers();
        when(userRepository.findAll()).thenReturn(expectedUsers);

        final List<User> users = userController.list();

        verify(userRepository).findAll();
        assertThat(users, is(notNullValue()));
        assertThat(users.size(), is(greaterThan(0)));
        assertThat(users.size(), is(expectedUsers.size()));
        assertThat(users, is(expectedUsers));

    }

    @Test
    void create() {

        User inputUser = new User();
        inputUser.setId(1L);
        when(userRepository.saveAndFlush(inputUser)).thenReturn(inputUser);

        User outputUser = userController.create(inputUser);

        verify(userRepository).saveAndFlush(inputUser);
        assertThat(outputUser.getId(), is(1L));
        assertThat(outputUser, is(inputUser));

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
        assertThat(user, is(expectedUser));

    }

    @Test
    void update() {

        final List<User> users = prepareUsers();
        User existingUser = users.get(0);
        User expectedUser = users.get(1);

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.saveAndFlush(existingUser)).thenReturn(expectedUser);

        final User user = userController.update(1L, existingUser);

        verify(userRepository).findById(1L);
        verify(userRepository).saveAndFlush(existingUser);
        assertThat(user.getId(), is(2L));
        assertThat(user, is(expectedUser));

    }

    @Test
    void delete() {

        User expectedUser = new User();
        expectedUser.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));
        doAnswer((i) -> null).when(userRepository).delete(expectedUser);

        final User user = userController.delete(1L);

        verify(userRepository).findById(1L);
        verify(userRepository).delete(expectedUser);
        assertThat(user.getId(), is(1L));
        assertThat(user, is(expectedUser));

    }

    private List<User> prepareUsers() {

        User user1 = new User();
        user1.setId(1L);

        User user2 = new User();
        user2.setId(2L);

        return Arrays.asList(user1, user2);

    }

}