package com.gorest.model;

import java.util.List;


public class UserPojo {


    private String name;

    private String email;
    private String gender;
    private List<String> status;

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String ge) {
        this.gender = gender;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }


}

