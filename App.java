import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Description:
 * - Creates/maintains a hand of 7 tiles.
 * - Asks the user for a word until they type "quit".
 * - If the word can be spelled from the current tiles, removes used tiles,
 *   prints the score, and refills back to 7 tiles.
 * - If not, informs the user.
 * 
 * @author Wonmin Song
 * @author Vickey Kang
 * @since 11/15/2025
 */
public class App {

    private static ArrayList<Tile> tiles;

    public static void main(String[] args) {
        System.out.println("Welcome to our Scrabble Game!");
        Scanner input = new Scanner(System.in);

        createAllTiles();
        ArrayList<Tile> hand = new ArrayList<>();  
        getNewTileSet(hand, 7);                 

        while (true) {

            printHand(hand);

            System.out.print("Enter your word: ");
            String word = input.nextLine();

            if (canSpell(hand, word)) {
                System.out.println("Yes! You can spell that word!");
                int score = computeScore(word);
                System.out.println("Score for '" + word + "': " + score);
                getNewTileSet(hand, 7);
            } else {
                System.out.println("Sorry, you cannot spell that word.");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String answer = input.nextLine().toLowerCase();

            if (answer.equals("no")) {
                System.out.println("See you then!");
                break;
            }
        }
    }


    /**
     * Fills the given tile set with random tiles until it reaches the expected size.
     *
     * @param currentSet the current set of tiles
     * @param expectedSize the desired total number of tiles in the set
     */
    public static void getNewTileSet(ArrayList<Tile> currentSet, int expectedSize) {
        Random rand = new Random();

        while (currentSet.size() < expectedSize) {
            int randIndex = rand.nextInt(tiles.size());
            currentSet.add(new Tile(tiles.get(randIndex)));
        }
    }

    /**
     * Checks if the given word can be spelled with the tiles in the set.
     * If it can, removes the used tiles from the set and returns true.
     * If it cannot, leaves the set unchanged and returns false.
     *
     * @param currentSet the current set of tiles
     * @param word the word to test
     * @return whether the word can be spelled
     */
    public static boolean canSpell(ArrayList<Tile> currentSet, String word) {
        String upperWord = word.toUpperCase();

        int[] counts = new int[26];
        for (Tile t : currentSet) {
            char c = Character.toUpperCase(t.getLetter());
            if (c >= 'A' && c <= 'Z') {
                counts[c - 'A']++;
            }
        }

        for (int i = 0; i < upperWord.length(); i++) {
            char c = upperWord.charAt(i);
            if (!Character.isLetter(c)) return false;

            c = Character.toUpperCase(c);
            int index = c - 'A';
            counts[index]--;

            if (counts[index] < 0) return false;
        }

        for (int i = 0; i < upperWord.length(); i++) {
            char needed = Character.toUpperCase(upperWord.charAt(i));

            for (int j = 0; j < currentSet.size(); j++) {
                if (Character.toUpperCase(currentSet.get(j).getLetter()) == needed) {
                    currentSet.remove(j);
                    break;
                }
            }
        }

        return true;
    }

    /**
     * Returns the Scrabble point value of the given letter.
     *
     * @param letter the letter to look up
     * @return the point value assigned to the letter (0 if not found)
     */
    public static int getTileValue(char letter) {
        char upper = Character.toUpperCase(letter);
        for (Tile t : tiles) {
            if (Character.toUpperCase(t.getLetter()) == upper) {
                return t.getValue();
            }
        }
        return 0;
    }

    /**
     * Calculates the total Scrabble score for the given word.
     * Each letter's value is added according to the standard tile values.
     *
     * @param word the word to be scored
     * @return the total score of the word
     */
    public static int computeScore(String word) {
        int total = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            total += getTileValue(c);
        }
        return total;
    }

    /**
     * Prints all tiles currently in the player's hand on one line.
     *
     * @param hand the list of Tile objects to display
     */
    public static void printHand(ArrayList<Tile> hand) {
        for (Tile t : hand) {
            System.out.print(t + "  ");
        }
        System.out.println();
    }

    public static void createAllTiles() {
        tiles = new ArrayList<Tile>();
        tiles.add(new Tile('A', 1));
        tiles.add(new Tile('B', 3));
        tiles.add(new Tile('C', 3));
        tiles.add(new Tile('D', 2));
        tiles.add(new Tile('E', 1));
        tiles.add(new Tile('F', 4));
        tiles.add(new Tile('G', 2));
        tiles.add(new Tile('H', 4));
        tiles.add(new Tile('I', 1));
        tiles.add(new Tile('J', 8));
        tiles.add(new Tile('K', 5));
        tiles.add(new Tile('L', 1));
        tiles.add(new Tile('M', 3));
        tiles.add(new Tile('N', 1));
        tiles.add(new Tile('O', 1));
        tiles.add(new Tile('P', 3));
        tiles.add(new Tile('Q', 10));
        tiles.add(new Tile('R', 1));
        tiles.add(new Tile('S', 1));
        tiles.add(new Tile('T', 1));
        tiles.add(new Tile('U', 1));
        tiles.add(new Tile('V', 4));
        tiles.add(new Tile('W', 4));
        tiles.add(new Tile('X', 8));
        tiles.add(new Tile('Y', 4));
        tiles.add(new Tile('Z', 10));
    }
}
