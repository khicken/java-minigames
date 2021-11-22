import java.util.Scanner;
import java.util.ArrayList;

public class Guess {
    // this class controls 
    private ArrayList<Character> guessedList;

    Guess() {
        guessedList = new ArrayList<>();
    }

    // returns true if guess hasn't been guessed before, false if guess has already been guessed before
    public boolean guessCharacter(char guess) {
        if(validAddition(guess)) {
            guessedList.add(guess);
            return true;
        }

        return false;
    }

    // helper method: checks if the character can be added
    private boolean validAddition(char guess) {
        for(char a: guessedList) {
            if(a == guess)
                return false;
        }

        return true;
    }

    // check if letter is in the word
    public static boolean correctGuess(String w, char g) {
        for(char a: w.toCharArray()) {
            if(g == a)
                return true;
        }

        return false;
    }

    public ArrayList<Character> getGuessedList() {
        return guessedList;
    }
}
