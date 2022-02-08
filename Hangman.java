import java.util.Scanner;
import java.util.Arrays;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("*********  WELCOME TO HANG MAN BY SUZ!!  *********");
        System.out.println("--------------------------------------------------");
        System.out.println(" \n ");

        System.out.println("Press any key to generate your word of the game!!!");
        scan.nextLine();

        String word = pickWord(words);
        //System.out.println(word);

        char[] placeholder = createPlaceholders(word);

        int misses = 0;

        char[] missedGuesses = new char[7];

        while (misses <= 5) {
            System.out.println(gallows[misses]);

            System.out.println("YOUR WORD: ");
            System.out.println(placeholder);
            System.out.println("  ");

            System.out.println("YOUR GUESSES: ");
            System.out.println(missedGuesses);
            System.out.println("  ");

            System.out.println("YOUR MISSES NUMBER: ");
            System.out.println(misses + " / 6 ");
            System.out.println("  ");

            System.out.println("Enter Your Guess here: ");
            char guess = scan.next().charAt(0);
            System.out.println(" \n ");

            if (checkLetter(guess, word) == true) {
                updatePlaceholder(word, placeholder, guess);
            } else {
                System.out.println("You missed!!");
                System.out.println(" \n ");

                misses++;
                missedGuesses[misses] = guess; //put the miss guess into the missedGuesses char array to print next loop
            }

            if (Arrays.equals(placeholder, word.toCharArray())) {
                System.out.println("YOU WIN!");
                System.out.println("YOUR WORD WAS: " + word);
                break;
            }

        }

        if (misses == 6) {
            System.out.println(gallows[6]);
            System.out.println("YOU LOSE! RIP!!! YOU DIED........");
            System.out.println("Your word was: " + word);
        }

        scan.close();
    }

    public static String pickWord(String[] words) {
        int random = (int)(Math.random() * words.length);
        String pickedWord = words[random];
        return pickedWord;
    }

    public static char[] createPlaceholders(String pickedWord) {
        char[] placeholder = new char[pickedWord.length()];
        for (int i = 0; i < pickedWord.length(); i++) {
            placeholder[i] = '-';
        }
        return placeholder;
    }

    public static boolean checkLetter(char guess, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            } 
        }
        return false;
    }

    public static void updatePlaceholder(String word, char[] placeholder, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                placeholder[i] = guess;
            }
        }
    }

}

