import java.util.ArrayList;

public class Guess {
    // this class controls 
    private ArrayList<Character> guessedList;

    Guess() {
        guessedList = new ArrayList<>();
    }

    // return number of characters found in the word
    public static int correctGuess(String w, char g) {
        int returnVal = 0;
        for(char a: w.toCharArray()) {
            if(g == Character.toLowerCase(a))
                returnVal++;
        }

        return returnVal;
    }

    // returns true if guess hasn't been guessed before, false if guess has already been guessed before
    public boolean validateGuess(char guess) {
        if(!guessedList.contains(guess)) {
            guessedList.add(guess);
            return true;
        }

        return false;
    }

    public ArrayList<Character> getGuessedList() {
        return guessedList;
    }
}
