package com.dailyquest.auth.dto.form;

import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String password;

}