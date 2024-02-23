package com.example.labactivity7socialnet;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface UserInterface {
    public String getName();
    public void setName(String name);
    public String getQuote();
    public void setQuote(String quote);
    public String getStatus();
    public void setStatus(String status);
    public String getProfileURL();
    public void setProfileURL(String profileURL);
    public ObservableList<String> getFriends();
    public void setFriends(ObservableList<String> friends);
    public void addFriend(String friend);
    public void removeFriend(String friend);
    public String getFriend(int index);
    public int getFriendCount();
}
