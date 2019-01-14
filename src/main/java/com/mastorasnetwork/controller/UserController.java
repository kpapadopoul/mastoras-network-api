package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @RequestMapping(value = "users", method = RequestMethod.GET)
    private List<User> list() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return new User();
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id) {
        return new User();
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id) {
        return new User();
    }

}
