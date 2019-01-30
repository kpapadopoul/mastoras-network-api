package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.User;
import com.mastorasnetwork.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("users")
    public User create(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @GetMapping("users/{id}")
    public User get(@PathVariable Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }

    }

    @PutMapping("users/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {

        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            BeanUtils.copyProperties(user, existingUser.get());
            return userRepository.saveAndFlush(existingUser.get());
        } else {
            return null;
        }

    }

    @DeleteMapping("users/{id}")
    public User delete(@PathVariable Long id) {

        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return existingUser.get();
        } else {
            return null;
        }

    }

}
