package org.example.api.helper.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"password"}) // Exclude password from the toString() method for security reasons
public class UserModel {
    private String username;
    private String password;
    private Integer age;
    private Boolean isMarried;
    private Double salary;
}


