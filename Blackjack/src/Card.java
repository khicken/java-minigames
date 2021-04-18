import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
    private int rank;
    private String suite;
    private int points;
    private String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suites = {"Hearts", "Diamonds", "Clubs", "Spades"};
    Card(Scanner scan) {
        rank = (int)(13*Math.random());
        suite = suites[(int)(4*Math.random())];
        points = rank + 1;
        if(names[rank].equals("Ace")) {
            setAceValue(scan);
        }
    }

    public String getNameOfCard() {
        return names[rank] + " of " + suite;
    }

    public int getPointValue() {
        if(rank >= 10) {
            return 10;
        }
        return points;
    }

    private void setAceValue(Scanner sc) {
        int input;
        System.out.println("Ace obtained! Would you like to set the value to 1 or 11? (Type 1 or 11)");
        try {
            input = sc.nextInt();
            if(input == 1 || input == 11) {
                points = input;
                return;
            }
        } catch(InputMismatchException e) { 
            System.out.println("Not a valid number!");
            setAceValue(sc);
        }

        System.out.println("Not a valid number!");
        setAceValue(sc);
    }
}
