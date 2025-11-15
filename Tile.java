/**
 * Description: The {@code Tile} class represents a Scrabble tile that contains 
 * a letter and its corresponding point value.
 *
 * This class includes constructors, getters, setters, and helper methods
 * used in the Scrabble game.
 * 
 * @author Wonmin Song
 * @author Vickey Kang
 * @since 11/15/2025
 */
public class Tile {
    private char letter;
    private int value;

    /**
     * Constructs a new Tile with a given letter and value.
     *
     * @param letter the alphabet letter on the tile
     * @param value  the Scrabble point value assigned to the letter
     */
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * Copy constructor — creates a new Tile object with the same
     * letter and value as the given Tile.
     *
     * @param obj the Tile object to copy
     */
    public Tile(Tile obj) {
        this.letter = obj.letter;
        this.value = obj.value;
    }

    /**
     * Sets the letter stored in this tile.
     *
     * @param letter the new letter to assign to this tile
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Sets the point value stored in this tile.
     *
     * @param value the new point value to assign
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the letter stored in this tile.
     *
     * @return the tile's letter
     */
    public char getLetter() {
        return this.letter;
    }

    /**
     * Returns the point value of this tile.
     *
     * @return the tile's score value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Compares this tile with another tile.
     * Two tiles are equal if their letters and values match.
     *
     * @param other the Tile object to compare with
     * @return true if both tiles have the same letter and value; false otherwise
     */
    public boolean equals(Tile other) {
        if (other == null) {
            return false;
        }
        return this.letter == other.letter && this.value == other.value;
    }

    /**
     * Returns a string representation of the tile in the form:
     * "A (1)" or "Z (10)"
     *
     * @return the formatted string showing letter and value
     */
    public String toString() {
        return String.format("%c (%d)", letter, value); 
    }
}
