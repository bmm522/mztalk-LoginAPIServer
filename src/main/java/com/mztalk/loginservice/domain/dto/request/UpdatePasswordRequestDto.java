package com.mztalk.loginservice.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePasswordRequestDto {

    private String username;
    private String password;
}
