import acm.program.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Hangman extends ConsoleProgram {
    // tracks game stats during the lifetime of the program.
    int bestScore = 0, gamesCount = 0, gamesWon = 0;
    String bestScoreWord = "";

    public void run() {
        int gameContinue = 1;

        // loop this to allow for multiple games.
        while (gameContinue == 1) {
            String fileName = promptUserForFile("Provide a dictionary to select a random word to guess from: ", "assets/");
            gameContinue = playOneGame(getRandomWord(fileName));

            stats(gamesCount, gamesWon, bestScore);
        }
    }

    // this method introduces the player to hangman.
    private void intro() {
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        println("Welcome to Hangman!");
        println("I will think of a random word.");
        println("You'll try to guess its letters.");
        println("Every time you guess a letter");
        println("that isn't in my word, a new body");
        println("part of the hanging man appears.");
        println("Good luck!");
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    // TODO: comment this method
    private int playOneGame(String secretWord) {
        // set the length of the secret word and
        // the boolean condition that dictates whether the game is running or not.
        int guessCount = 8;
        String guessedLetters = "";
        String hintString = "";

        // run the methods necessary for displaying the game.
        while (true) {
            // display the blanks and guessed letters.
            hintString = createHint(secretWord, guessedLetters);
            println("Secret word: " + hintString);
            println("Guesses left: " + guessCount);
            println("Your guessed letters: " + guessedLetters);

            // display the hangman graphic in the canvas.
            displayHangman(guessCount);

            // check for game over. this is placed here so that the function can exit before the user inputs a word.
            if (guessCount == 0) {
                println("Game over.");
                println("The word was: " + secretWord);
                break;
            } else if (!hintString.contains("_ ")) {
                println("You won.");
                break;
            }

            // add the user's guessed letter to a temp variable.
            char latestUserGuess = readGuess(guessedLetters);

            // if the user's guess is not in the word to be guessed, subtract 1 from lives (guessCount).
            if (!secretWord.contains(latestUserGuess + "")) {
                guessCount--;
            }

            // add the latest user guess to the guessedLetters string.
            guessedLetters += latestUserGuess;
        }

        // add a win to the stats if the player won.
        if (guessCount > 0) {
            gamesWon++;

            // if your guess count is higher, set it as your best score and keep track of the word.
            if (guessCount > bestScore) {
                bestScore = guessCount;
                bestScoreWord = secretWord;
            }
        }

        gamesCount++;

        // ask the user if they want to continue or not.
        String userChoice = "";
        userChoice = getLine("Would you like to play another game? (Y/N): ").toUpperCase();

        if (Objects.equals(userChoice, "Y")) {
            return 1;
        } else {
            return 0;
        }
    }


    // creates the hint that displays the blanks and the user's guessed letters.
    private String createHint(String secretWord, String guessedLetters) {
        // length of secret word.
        int lengthOfSecretWord = secretWord.length();

        // new string of guessed letters to be returned.
        String newGuessedLetters = new String();

        // display the blanks and guessed letters that match.
        for (int i = 0; i < lengthOfSecretWord; i++) {
            // checks if the "guessedLetters" list contains a letter equal to the ith letter in "secretWord".
            // the quotation marks convert the character to a string.
            // if a match is found, concatenate the ith letter in "secretWord" to newGuessedLetters.
            // otherwise, concatenate a blank to newGuessedLetters.
            if (guessedLetters.contains(secretWord.charAt(i) + "")) {
                newGuessedLetters += secretWord.charAt(i);
            } else {
                newGuessedLetters += "_ ";
            }
        }
        return newGuessedLetters;
    }

    // reads input from the user, verifies the validity of the input, and returns the character.
    private char readGuess(String guessedLetters) {
        /* Loop to make sure input is valid as explained above*/
        while(true) {
            boolean notDuplicate = true;
            /* Input */
            String getCharacter = getLine("Guess a letter: ");
            /* Change to Uppercase */
            getCharacter = getCharacter.toUpperCase();
            /* Condition for [1] a single letter (A-Z) */
            if (getCharacter.length() != 1) {
                println("Input one letter.");
            }
            /* Checker for [2] been guessed already */
            else if (guessedLetters.contains(getCharacter)) {
                println("You have already guessed this letter.");
            }
            /* if neither of those error conditions are met, add the character to guessedLetters and return that */
            else {
                return getCharacter.charAt(0);
            }
        }
    }

    // displays the hangman graphic on the canvas.
    private void displayHangman(int guessCount) {
        File file = new File("assets/display" + guessCount + ".txt");
        Scanner scanner = null;
        canvas.clear();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                canvas.printText(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // displays the number of games played in a session, games won, and the best score.
    private void stats(int gamesCount, int gamesWon, int best) {
        println("\n\nGames played this session: " + gamesCount);
        println("Games won this session: " + gamesWon);

        if (gamesWon > 0) {
            println("Your best score this session was " + best + " guesses remaining for the word '" + bestScoreWord + "'.\n\n");
        } else {
            println("You do not have a best score this session, as you have not won a game yet.");
        }
    }

    // gets a random word from a provided dictionary .txt file.
    private String getRandomWord(String filename) {
        Scanner dictScanner = null;

        try {
            File dictionary = new File(filename);
            dictScanner = new Scanner(dictionary);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ArrayList<String> wordList = new ArrayList<>();

        // tracks the number of words
        int numWords = Integer.parseInt(dictScanner.nextLine());

        // scan all lines in the dictionary and add each word to the list above.
        while (dictScanner.hasNext()) {
            String word = dictScanner.nextLine();
            wordList.add(word);
        }

        Random randomNumber = new Random();

        return wordList.get(randomNumber.nextInt(numWords));
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();  // sample canvas method call
        displayHangman(8);
        intro();
    }


    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Hangman().start(args);
    }


    // private HangmanCanvas canvas;
    private HangmanCanvas canvas;
}
