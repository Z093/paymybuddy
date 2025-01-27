package com.example.paymybuddy.repository;

import com.example.paymybuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserFriendsRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);

}
