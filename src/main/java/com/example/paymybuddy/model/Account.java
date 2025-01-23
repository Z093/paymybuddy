package com.example.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Double balance;

    @OneToOne
    @JoinColumn(name = "user_id")

    private User user;


}

