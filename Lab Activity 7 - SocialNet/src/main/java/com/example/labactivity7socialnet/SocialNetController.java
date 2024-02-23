package com.example.labactivity7socialnet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class SocialNetController {
    // tracks the index of the user being viewed onscreen at any given moment.
    int currentUserIndex = 0;
    @FXML
    UserDatabase database = new UserDatabase();
    @FXML
    private Text userName;
    @FXML
    private Text userStatus;
    @FXML
    private Text userQuote;
    @FXML
    private ImageView userProfilePicture;
    @FXML
    private ListView<String> friendList;
    @FXML
    private TextField personLookupField;
    @FXML
    private Label appStatus;
    @FXML
    private TextField statusField;
    @FXML
    private TextField profilePictureField;
    @FXML
    private TextField quoteField;
    @FXML
    private TextField addFriendField;
    @FXML
    private TextField removeFriendField;

    @FXML
    private void initialize() {
        database.loadDatabase("src/main/resources/userDatabase.txt");

        updateView(0);
    }

    // update the status label at the bottom right.
    @FXML
    private void updateAppStatus(String status) {
        appStatus.setText(status);
    }

    // search for a match in the database based on the text entered in lookupField. returns the index of the matched user, and -1 if no match is found.
    @FXML
    private int searchForMatch(String query) {
        if (query != null) {
            for (int i = 0; i < database.getSizeOfDatabase(); i++) {
                if (database.getUser(i).getName().toUpperCase().equals(query.toUpperCase())) {
                    return i;
                }
            }
        }

        return -1;
    }

    // update the on-screen graphics.
    @FXML
    private void updateView(int index) {
        ObservableList<String> initialFriendList = FXCollections.observableArrayList();
        // loop through each of the initial user's friends and save all of their friend's names to the observable list.
        for (int i = 0; i < database.getUser(index).getFriendCount(); i++) {
            initialFriendList.add(database.getUser(index).getFriend(i));
        }

        userName.setText(database.getUser(index).getName());
        userStatus.setText(database.getUser(index).getStatus());
        userQuote.setText("\"" + database.getUser(index).getQuote() + "\"");
        userProfilePicture.setImage(new Image(database.getUser(index).getProfileURL()));
        friendList.setItems(initialFriendList);

        currentUserIndex = index;
    }

    // remove a person from the database when the button is pressed.
    @FXML
    private void onRemoveDatabaseButtonPressed() {
        int indexToRemove = searchForMatch(personLookupField.getText());
        if (indexToRemove != -1) {
            updateAppStatus("Removed user " + database.getUser(indexToRemove).getName() + " from the database.");
            database.removeUser(database.getUser(searchForMatch(personLookupField.getText())));
            updateView(0);
        } else {
            updateAppStatus("No profiles found with that name. Check for any spelling mistakes.");
        }
    }

    // search for a person in the database when the button is pressed.
    @FXML
    private void onLookupDatabaseButtonPressed() {
        int indexToRemove = searchForMatch(personLookupField.getText());
        if (indexToRemove != -1) {
            updateAppStatus("Viewing " + database.getUser(searchForMatch(personLookupField.getText())).getName() + "'s profile.");
            updateView(searchForMatch(personLookupField.getText()));
        } else {
            updateAppStatus("No profiles found with that name. Check for any spelling mistakes.");
        }
    }

    // return the current user's index in the database.
    @FXML
    private int getCurrentUserIndex() {
        return currentUserIndex;
    }

    // add a person to the database when the button is pressed.
    @FXML
    private void onAddPersonDatabaseButtonPressed() {
        String lookupField = personLookupField.getText();
        if (searchForMatch(lookupField) == -1) {
            database.addUser(lookupField);
            updateAppStatus("User " + lookupField + " was added to the database.");
        } else {
            updateAppStatus("The user was not added. A user already exists with that name.");
        }
    }

    // update status
    @FXML
    private void onUpdateStatusButtonPressed() {
        String statusFieldText = statusField.getText();
        if (statusFieldText != null) {
            database.getUser(getCurrentUserIndex()).setStatus(statusFieldText);
            updateAppStatus("User " + database.getUser(getCurrentUserIndex()).getName() + "'s status was updated.");
            updateView(getCurrentUserIndex());
        } else {
            updateAppStatus("Type something to update your status.");
        }
    }

    // update profile picture
    @FXML
    private void onUpdateProfilePictureButtonPressed() {
        String profilePictureFieldText = profilePictureField.getText();
        if (profilePictureFieldText != null) {
            database.getUser(getCurrentUserIndex()).setProfileURL(profilePictureFieldText);
            updateAppStatus("User " + database.getUser(getCurrentUserIndex()).getName() + "'s profile picture was updated.");
            updateView(getCurrentUserIndex());
        } else {
            updateAppStatus("Type a valid path to an image you want to set as your profile picture.");
        }
    }

    // update the current user's quote.
    @FXML
    private void onUpdateQuoteButtonPressed() {
        String quoteFieldText = quoteField.getText();
        if (quoteFieldText != null) {
            database.getUser(getCurrentUserIndex()).setQuote(quoteFieldText);
            updateAppStatus("User " + database.getUser(getCurrentUserIndex()).getName() + "'s quote was updated.");
            updateView(getCurrentUserIndex());
        } else {
            updateAppStatus("Type something to change the quote displayed on your profile.");
        }
    }

    // add a person to the current user's friends list.
    @FXML
    private void onAddFriendButtonPressed() {
        String addFriendFieldText = addFriendField.getText();
        // if the field isn't empty, the person exists in the database, and isn't already in the current user's friends list, add them.
        if (addFriendFieldText != null && searchForMatch(addFriendFieldText) != -1 && !database.getUser(getCurrentUserIndex()).friends.contains(addFriendFieldText)) {
            database.getUser(getCurrentUserIndex()).addFriend(addFriendFieldText);
            updateAppStatus("User " + addFriendFieldText + " has been added to " + database.getUser(getCurrentUserIndex()).getName() + "'s friend list.");
            updateView(getCurrentUserIndex());
        } else {
            updateAppStatus("Could not add friend. This user is not in the database.");
        }
    }

    // remove a person from the current user's friends list.
    @FXML
    private void onRemoveFriendButtonPressed() {
        String removeFriendFieldText = removeFriendField.getText();
        // similar deal to the method where you add a friend, but it checks if the name is in the user's friends list before removing it.
        if (removeFriendFieldText != null && searchForMatch(removeFriendFieldText) != -1 && database.getUser(getCurrentUserIndex()).friends.contains(removeFriendFieldText)) {
            database.getUser(getCurrentUserIndex()).removeFriend(removeFriendFieldText);
            updateAppStatus("User " + removeFriendFieldText + " has been removed from " + database.getUser(getCurrentUserIndex()).getName() + "'s friend list.");
            updateView(getCurrentUserIndex());
        } else {
            updateAppStatus("Could not remove friend. They are not in your friends list.");
        }
    }
}