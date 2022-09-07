package com.dzmitry.user;

import lombok.Data;

@Data
public class CrmUser {

    private String userName;
    private String password;
    private String matchingPassword;
    private String firstName;
    private String lastName;
    private String email;
    
}
