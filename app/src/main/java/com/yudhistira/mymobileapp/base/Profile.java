package com.yudhistira.mymobileapp.base;

import java.io.Serializable;

public class Profile implements Serializable {
    public String name;
    public String password;

    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
