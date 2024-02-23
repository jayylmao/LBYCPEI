package com.example.labactivity7socialnet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserDatabase {
    ObservableList<User> userList = FXCollections.observableArrayList();

    // load the csv.
    public void loadDatabase(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner text = new Scanner(fileReader);
            String[] userInfo = null;
            int lineCount = 0;

            // loop through csv file.
            while (text.hasNext()) {
                String line = text.nextLine();

                userInfo = line.split(",");

                // create user object and add to list with name, status, quote, and profile picture path.
                addUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);

                if (userInfo.length > 4) {
                    for (int i = 4; i < userInfo.length; i++) {
                        // set current user to user object at index lineCount.
                        User currentUser = getUser(lineCount);

                        // search for user object with matching name and add it to the current user's friend list.
                        String friend = userInfo[i];
                        if (friend != null) {
                            currentUser.addFriend(friend);
                        }
                    }
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    public void addUser(String name, String quote, String status, String profileURL) {
        User user = new User(name, quote, status, profileURL);
        userList.add(user);
    }

    public void addUser(String name) {
        User user = new User(name, "Insert a quote here.", "Type your status here.", "placeholder.jpg");
        userList.add(user);
    }

    // remove a user from the database.
    public void removeUser(User user) { userList.remove(user); }
    // get the user at a specified index.
    public User getUser(int index) { return userList.get(index); }
    // get the user with the specified name.
    public User getUser(String userName) {
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    // get the index of a specified user.
    public int getIndex(User user) { return userList.indexOf(user); }
    // get the size of the user database.
    public int getSizeOfDatabase() { return userList.size(); }
}
