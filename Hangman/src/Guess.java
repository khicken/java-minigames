import java.util.ArrayList;

public class Guess {
    // this class controls 
    private ArrayList<Character> guessedList;

    Guess() {
        guessedList = new ArrayList<>();
    }

    // check if letter is in the word
    public static boolean correctGuess(String w, char g) {
        for(char a: w.toCharArray()) {
            if(g == a)
                return true;
        }

        return false;
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
