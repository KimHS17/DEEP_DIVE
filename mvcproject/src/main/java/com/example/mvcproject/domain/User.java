package com.example.mvcproject.domain;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Integer age;

    public User() {
        this.name = "John Doe";
        this.email = "test@test.com";
        this.password = "password";
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", email: " + email + ", password: " + password + ", age: " + age;
    }
}
