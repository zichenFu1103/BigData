package com.zichen.domain;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 7398833268354040862L;

    private String username;
    private String password;

    public User(){}

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
