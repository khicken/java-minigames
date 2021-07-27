import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Guess> deck = new ArrayList<Guess>();
    Scanner sc = new Scanner(System.in);
    String input;
    int lives = 10;
    String screen = "welcome";

    public void play() {
        welcomeScreen();
        if(screen.equals("rules"))
            rulesScreen();
        gameScreen();
    }

    private void welcomeScreen() {
        System.out.println("Welcome to Hangman! ");
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
        System.out.println("\n\n\nIn Hangman, try to guess a word by continually entering characters. However, incorrectly guessing a character loses a life.\n Guess the word to win, or lose all your lives and you lose!\n ");
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
            System.out.println("What letter would you like to guess?");
            System.out.println("Lives: " + lives);
            
            input = sc.nextLine().toLowerCase();
            if(input.equals("s")) {
                break;
            } else if(input.equals("q")) {
                System.exit(0);
            } else if(input.equals("h")) {
                deck.add(new Guess(sc));
                System.out.println("You have got the " + deck.get(deck.size()-1).getNameOfCard() + "!");
                score += deck.get(deck.size()-1).getPointValue();
                System.out.println("Your score: " + score + "\n\n\n");
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
}
