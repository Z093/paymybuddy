package com.example.paymybuddy.service;

import com.example.paymybuddy.model.User;
import com.example.paymybuddy.model.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

@Service
public class UserLoginMapperService {

    public UserLoginDTO toDTO(User user){
        return new UserLoginDTO(
                user.getMail(),
                user.getPassword()
        );
    }
}
