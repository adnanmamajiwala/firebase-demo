package com.sample.firebase.security;

public enum Roles {

    SUPER("super"),
    ADMIN("admin"),
    USER("user");

    private String code;

    Roles(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
