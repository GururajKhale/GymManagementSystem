package com.example.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private double height;
    private double weight;
    private int age;
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;



}
