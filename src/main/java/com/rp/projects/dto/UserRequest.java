package com.rp.projects.dto;

public class UserRequest {


    private String name ;
    private String email ;

    private int age ;

    private String city ;
    private String gender ;

    public UserRequest() {
    }

    public UserRequest(String name, String email, int age, String city, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.city = city;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
