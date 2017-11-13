/**
 * Abstract class for all chess pieces
 * @author dds7
 * @version 2
 */
public abstract class Piece {
    private Color color;
    /**
     * Constructor for a piece
     * @param color the color of a given piece
     */
    public Piece(Color color) {
        this.color = color;
    }
    /**
     * Gets color of this piece
     * @return the color of a chess piece
     */
    public Color getColor() {
        return color;
    }
    /**
     * Gets the Algebraic name of this piece
     * @return this piece's algebraic name
     */
    public abstract String algebraicName();
    /**
     * Gets the FEN name of this piece
     * @return this piece's FEN name
     */
    public abstract String fenName();
    /**
     * Gets an Array of possible Squares a given piece can move to
     * @return Array of possible Squares a given piece can move to
     * @param square the starting Square
     */
    public abstract Square[] movesFrom(Square square);

    /**
     * Returns a String representation of this Piece
     * @return a String representation of this Piece
     */
    public String toString() {
        return color.toString() + " " + this.getClass();
    }

    /**
     * Returns if this Piece is on the board
     * @param rank the rank of this position
     * @param file the filt of this position
     * @return if this Piece is on the board
     */
    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }
}