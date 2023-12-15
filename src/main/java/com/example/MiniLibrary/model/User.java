package com.example.MiniLibrary.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Entity(name = "User")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @Setter
   @Column(name = "fullname")
   @Length(min = 6, max = 15, message = "Please enter your first and last name")
    private  String fullName;

    @Setter
    @Length(min = 18, max = 70, message = "Please enter your age")
    private int age;

    @Setter
    @Column(unique = true)
    @Email(message = "Please enter a valid email")
    private String email;

    @Setter
    @Valid
    @NotBlank(message = "Enter a valid address")
    private  String address;

    public User(Long id, String fullName, int age, String email, String address) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.address = address;


    }

    public User() {

    }
}
