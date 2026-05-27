package com.gramutsav.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

    private String mobileno;
    private String password;

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
