package com.company.atelier_manager.structure;

public class User {
    private final long id;
    private String name;
    private String email;
    private String pasword;

    public User(long id, String name, String email, String pasword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pasword = pasword;
    }

    public User(String name, String email, String pasword) {
        this.id = -1;
        this.name = name;
        this.email = email;
        this.pasword = pasword;
    }

    public long getId() {
        return id;
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

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
