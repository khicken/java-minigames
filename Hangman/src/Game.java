import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Game {
    String screen = "welcome";

    Scanner sc = new Scanner(System.in);
    String input;

    ArrayList<Guess> guesses = new ArrayList<Guess>();
    String word;
    char currentGuess;
    int lives = 6;

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
        while(screen.equals("play")) {
            word = generateWord();

            System.out.println(word);

            System.out.println("What letter would you like to guess?");
            System.out.println("Lives: " + lives);
            
            input = sc.nextLine().toLowerCase();
            currentGuess = input.charAt(0);

            

            if(input.equals("s")) {
                break;
            } else if(input.equals("q")) {
                System.exit(0);
            } else {
                System.out.println("\n\n\nInvalid input, try again! Type h for hit, s to stay, or q to quit.");
            }
        }

        if(screen.equals("win-ace"))
            System.out.println("Congrats on winning without losing a single life! Amazing! Thanks for playing!");
        else if(screen.equals("win"))
            System.out.println("Congrats on winning! Try to get no letters wrong next time!");
        else
            System.out.println("Ouch! Better luck next time!");
    }

    private String generateWord() {
        return Main.wordlist[(int)(Math.floor(Math.random()*Main.words))];
    }
}
