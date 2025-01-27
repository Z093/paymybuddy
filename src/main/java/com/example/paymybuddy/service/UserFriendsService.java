package com.example.paymybuddy.service;

import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserFriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFriendsService {

    @Autowired
    private UserFriendsRepository userFriendsRepository;

    public void addFriend(String userMail, String friendMail) {
        User user = userFriendsRepository.findByMail(userMail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User friend = userFriendsRepository.findByMail(friendMail)
                .orElseThrow(() -> new RuntimeException("Friend not found"));

        // Ajoutez le contact si ce n'est pas déjà un ami
        if (!user.getFriends().contains(friend)) {
            user.getFriends().add(friend);
            userFriendsRepository.save(user);
        } else {
            throw new RuntimeException("This user is already a friend");
        }
    }
}
