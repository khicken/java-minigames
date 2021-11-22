import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static final int words = 859; // lines in the list.txt file, this needs to be manually updated
    public static String[] wordlist = new String[words];
    private static final String listPath = System.getProperty("user.dir") + "/Hangman/src/list.txt";

    private static void init() { // moves wordlist into an array
        try {
            Scanner reader = new Scanner(new File(listPath));
            int i = 0;
            while(reader.hasNextLine()) {
                wordlist[i] = reader.nextLine();
                i++;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        init();

        game.play();
    }
}
