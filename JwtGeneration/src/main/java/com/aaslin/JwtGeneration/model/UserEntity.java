package com.aaslin.JwtGeneration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users_jerusha")
public class UserEntity {


    @Id
    private String username;
    @NotBlank(message = "Please provide your email")
    private String email;
    private String mobileNumber;
    private Date dob;
    private String designation;
    private String password;
}
