import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Card> deck = new ArrayList<Card>();
    Scanner sc = new Scanner(System.in);
    String input;
    int score;
    String screen = "welcome";

    public void play() {
        welcomeScreen();
        if(screen.equals("rules"))
            rulesScreen();
        gameScreen();
    }

    private void welcomeScreen() {
        System.out.println("Welcome to Blackjack! Would you like the rules? Type y for yes, n for no. \nIf you'd like to quit, type q");
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
        System.out.println("In Blackjack, each card has a value ranging from 1-11. Royal cards (kings, queens, jacks) are worth 10 points of score each.\nAces are worth either 1 or 11 points, you may choose. The number cards are worth their value (e.g. a 4 of hearts is worth 4 points).\n The goal of Blackjack is to get 21 points of score, or as close as you can to it. If you go over 21 points however, you bust and lose the game immediately.\n ");
        System.out.println("To play, press enter to continue...");
        try {
            System.in.read();
        } catch(Exception e) {
            System.out.println("Error ocurred! " + e);
        }

        screen = "play";
    }

    private void gameScreen() {
        System.out.print("Hello! ");
        while(score < 21) {
            System.out.println("Would you like to hit (h) or stay (s)? You can also quit if you'd like (q).");
            
            input = sc.nextLine().toLowerCase();
            if(input.equals("s")) {
                break;
            } else if(input.equals("q")) {
                System.exit(0);
            } else if(input.equals("h")) {
                deck.add(new Card(sc));
                System.out.println("You have got the " + deck.get(deck.size()-1).getNameOfCard() + "!");
                score += deck.get(deck.size()-1).getPointValue();
                System.out.println("Your score: " + score);
            } else {
                System.out.println("Invalid input, try again! Type h for hit, s to stay, or q to quit.");
            }
        }

        if(score == 21) {
            System.out.println("Congrats on winning! You hit 21! Thanks for playing.");
        } else if(score > 21) {
            System.out.println("Oh no! You lose! Thanks for playing.");
        } else {
            System.out.println("Great job! Final score: " + score);
        }
    }
}
