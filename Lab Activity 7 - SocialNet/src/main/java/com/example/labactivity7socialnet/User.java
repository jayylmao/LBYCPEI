package com.example.labactivity7socialnet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class User implements UserInterface {
    UserDatabase database = new UserDatabase();
    protected String name;
    protected String quote;
    protected String status;
    protected String profileURL;
    protected ObservableList<String> friends = FXCollections.observableArrayList();

    public User(String name) {
        this.name = name;
        this.quote = "";
        this.status = "";
        this.profileURL = "placeholder.png";
        this.friends = FXCollections.emptyObservableList();
    }

    public User(String name, String quote, String status, String profileURL) {
        this.name = name;
        this.quote = quote;
        this.status = status;
        this.profileURL = profileURL;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getQuote() { return quote; }
    public void setQuote(String quote) { this.quote = quote; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getProfileURL() { return profileURL; }
    public void setProfileURL(String profileURL) { this.profileURL = profileURL; }
    public ObservableList<String> getFriends() { return friends; }
    public void setFriends(ObservableList<String> friends) { this.friends = friends; }
    public void addFriend(String friend) { this.friends.add(friend); }
    public void removeFriend(String friend) { this.friends.remove(friend); }
    public String getFriend(int index) { return this.friends.get(index); }
    public int getFriendCount() { return this.friends.size(); }
}
