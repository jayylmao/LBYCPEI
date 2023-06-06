import acm.program.*;

public class Hangman extends ConsoleProgram {

    public void run() {
        playOneGame("PROGRAMMER");
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
        boolean gameIsRunning = true;
        int guessCount = 0;
        String guessedLetters = "PR";

        // run the methods necessary for displaying
        while (gameIsRunning) {
            // display the hangman graphic in the canvas.
            displayHangman(guessCount);

            // display the blanks and guessed letters.
            createHint(secretWord, guessedLetters);

            //
            readGuess();

        }

        return 0;
    }


    // TODO: comment this method
    private String createHint(String secretWord, String guessedLetters) {
        // length of secret word.
        int lengthOfSecretWord = secretWord.length();
        int numberOfGuessedLetters = guessedLetters.length();

        // new string of guessed letters to be returned.
        String newGuessedLetters = new String();

        // display the blanks and guessed letters that match.
        for (int i = 0; i < lengthOfSecretWord; i++) {
            // checks if the "guessedLetters" list contains a letter equal to the ith letter in "secretWord".
            // the quotation marks convert the character to a string.
            // if a match is found, concatenate the ith letter in "secretWord" to newGuessedLetters.
            // otherwise, concatenate a blank to newGuessedLetters.
            if (guessedLetters.contains(secretWord.charAt(i) + "")) {
                newGuessedLetters.concat(secretWord.charAt(i) + " ");
            } else {
                newGuessedLetters.concat("_ ");
            }
        }
        return newGuessedLetters;
    }

    // TODO: change this back to char and return a character
    private void readGuess(String guessedLetters) {
        /* Loop to make sure input is valid as explained above*/
        while(true) {
            boolean notDuplicate = true;
            /* Input */
            String getCharacter = getLine("Your guess? ");
            /* Change to Uppercase */
            getCharacter = getCharacter.toUpperCase();
            /* Condition for [1] a single letter (A-Z) */
            /* Checker for [2] been guessed already */
            /* Handle if character exists in guessedLetters */
            /*You should re-prompt the user until they type a
            string that is a single letter from A-Z,
            case-insensitive, that has not been guessed before! */
        }
    }

    // TODO: comment this method
    private void displayHangman(int guessCount) {
        // TODO: write this method
    }

    // TODO: comment this method
    private void stats(int gamesCount, int gamesWon, int best) {
        // TODO: write this method
    }

    // TODO: comment this method
    private String getRandomWord(String filename) {
        // TODO: write this method
        return "";
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();  // sample canvas method call
        intro();
    }


    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Hangman().start(args);
    }


    // private HangmanCanvas canvas;
    private HangmanCanvas canvas;
}
