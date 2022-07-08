package com.example.socialmediaapp.models;

public class DashBoardModel {
    int profile,image,save;
    String name,about,likes,comments,shares;
    public DashBoardModel(int profile, int image, int save, String name, String about, String likes, String comments, String shares) {
        this.profile = profile;
        this.image = image;
        this.save = save;
        this.name = name;
        this.about = about;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

}
