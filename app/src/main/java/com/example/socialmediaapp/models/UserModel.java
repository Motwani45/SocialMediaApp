package com.example.socialmediaapp.models;

public class UserModel {
    private String name,profession,email,about;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public UserModel(String name, String profession, String email, String about) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.about = about;
    }
}
