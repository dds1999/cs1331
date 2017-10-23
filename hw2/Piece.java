/**
 * Abstract class for all chess pieces
 * @author dds7
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
     * @return the color of a chess piece
     */
    public Color getColor() {
        return color;
    }
    /**
     * @return this piece's algebraic name
     */
    public abstract String algebraicName();
    /**
     * @return this piece's FEN name
     */
    public abstract String fenName();
    public abstract Square[] movesFrom(Square square);
}