package com.google.sps.entity;
import java.util.Date;


public class PersonInfo {

    private String phone_number;
    private Date birthday;
    private String address;
    private String email;

    public PersonInfo(String phone_number, Date birthday, String address, String email) {
        this.phone_number = phone_number;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
    }

    public PersonInfo() {

    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}