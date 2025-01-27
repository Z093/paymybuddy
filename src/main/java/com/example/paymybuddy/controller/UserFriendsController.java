package com.example.paymybuddy.controller;

import com.example.paymybuddy.service.UserFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserFriendsController {

    @Autowired
    private UserFriendsService userFriendsService;

    @PostMapping("/{userMail}/friends")
    public void addFriend(@PathVariable String userMail, @RequestParam String friendMail) {
        userFriendsService.addFriend(userMail, friendMail);
    }
}
