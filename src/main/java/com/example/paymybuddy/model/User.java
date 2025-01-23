package com.example.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name ="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String mail;
    private String password;
    private String fistName;
    private String lastName;
    private double balance;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;



}
