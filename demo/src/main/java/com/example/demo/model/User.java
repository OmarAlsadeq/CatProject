package com.example.demo.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class User extends AbstractEntity {
    @NotNull
    private String username;
    @NotNull
    private String pwHash;
    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;



    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String username, String password, String contactEmail) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.contactEmail = contactEmail;
    }

    public User(String username, String password) {
        super();
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
