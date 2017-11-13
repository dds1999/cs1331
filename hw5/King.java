/**
 * Represents a king chess object
 * @author dds7
 * @version 2
 */
public class King extends Piece {
    /**
     * Constructor for a king
     * @param color the color of a given king
     */
    public King(Color color) {
        super(color);
    }
    /**
     * @return this piece's algebraic name
     */
    @Override public String algebraicName() {
        return "K";
    }
    /**
     * @return this piece's FEN name
     */
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "K";
        }
        return "k";
    }
    /**
     * @param square the starting square of this piece
     * @return this an array of possible squares this piece could move to
     */
    @Override public Square[] movesFrom(Square square) {
        Square[] sq = new Square[8];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }
                if (isInBoard((char) (file + c), (char) (rank + r))) {
                    sq[counter] = new Square((char) (file + c),
                        (char) (rank + r));
                    counter++;
                }
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}