package com.mztalk.loginservice.user.repository.entity.util;

public enum Role {

    ROLE_ADMIN("ROLE_ADMIN"), out("out"), N("N"), ROLE_USER("ROLE_USER");

    private final String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
