package com.hotels.form.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by sandeep on 4/19/2015.
 */
public class User {
    @NotEmpty
    @Size(min = 6, max = 8)
    private String userName;

    @NotEmpty
    @Size(min = 6, max = 8)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
