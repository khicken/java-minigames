import java.util.Scanner;
import java.util.ArrayList;

public class Guess {
    // this class controls 
    private ArrayList<Character> guessedList = new ArrayList<>();

    Guess() {
        
    }

    // returns true if guess hasn't been guessed before, false if guess has already been guessed before
    private boolean guessCharacter(char guess) {
        if(validAddition(guess)) {
            guessedList.add(guess);
            return true;
        }

        return false;
    }


    // checks if the character can be added
    private boolean validAddition(char guess) {
        for(char a: guessedList) {
            if(a == guess)
                return false;
        }

        return true;
    }

    public ArrayList<Character> getGuessedList() {
        return guessedList;
    }
}
