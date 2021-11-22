import java.util.Scanner;
import java.lang.Math;

public class Game {
    String screen = "welcome";
    String[] endings = {"gg", "gg ez", "Good Game", "well played", "gg wp ez brb nt", "Great job!", "Awesome job!", "Supercalifragolisticexpialidocious to you!", "bruh meme", "great game"};

    Scanner sc = new Scanner(System.in);
    String input;

    Guess guesses = new Guess();
    String word;
    char currentGuess;
    int lives = 6, lettersLeft = 0; // lettersLeft will be set to the real value later

    public void play() {
        welcomeScreen();
        if(screen.equals("rules"))
            rulesScreen();
        gameScreen();
    }

    private void welcomeScreen() {
        System.out.println("Welcome to Hangman! Type 'y' if you'd like the rules, 'n' to skip or 'q' to quit.");
        while(true) {
            input = sc.nextLine().toLowerCase();
            if(input.equals("y")) {
                screen = "rules";
                break;
            } else if(input.equals("n")) {
                screen = "play";
                break;
            } else if(input.equals("q")) {
                System.exit(0);
            }

            System.out.println("Invalid input, try again! Input y for yes, n for no, q to quit.");
        }
    }

    private void rulesScreen() {
        System.out.println("\n\n\nHow do you not know how to play Hangman? Just guess characters until something works.\n ");
        System.out.println("To play, press enter to continue...");
        try {
            System.in.read();
        } catch(Exception e) {
            System.out.println("Error ocurred! " + e);
        }

        screen = "play";
    }

    private void gameScreen() {
        System.out.print("\n\n\nHello! ");
        word = generateWord();
        lettersLeft = word.length();
        while(screen.equals("play")) {
            System.out.println("What letter would you like to guess?");
            System.out.println(wordDisplay(word, guesses));
            System.out.println("Lives: " + lives);
            
            input = sc.nextLine().toLowerCase();
            currentGuess = input.charAt(0);

            if(Guess.correctGuess(word, currentGuess)) {
                System.out.println("Nice job!");
                lettersLeft -= 1;
            } else {
                System.out.println("Incorrect guess, try again!");
                lives -= 1;
            }

            if(lettersLeft == 0) {
                // when player finished game
                System.out.println("\n\n\n" + (int)Math.floor(Math.random()*endings.length));
                break;
            } else if(lives == 0) {
                System.out.println("nice you died");
                break;
            }
        }
    }

    private String wordDisplay(String w, Guess g) {
        String output = "";

        for(int i = 0; i < w.length(); i++) {
            if(g.getGuessedList().contains(w.toCharArray()[i]))
                output += w.toCharArray()[i] + " ";
            else
                output += "_ ";
        }

        return output;
    }

    private String generateWord() {
        return Main.wordlist[(int)(Math.floor(Math.random()*Main.words))];
    }
}
