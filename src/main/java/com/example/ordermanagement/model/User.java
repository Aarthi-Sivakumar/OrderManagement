package com.example.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    @NotNull
    private Category userName;
    @NotNull
    private long mobile;
    @NotNull
    @Email
    private String mail;

    public enum Category{
        ADMIN,
        SELLER,
        BUYER
    }
}
