/**
 * Represents a pawn chess object
 * @author dds7
 * @version 2
 */
public class Pawn extends Piece {
    /**
     * Constructor for a pawn
     * @param color the color of a given pawn
     */
    public Pawn(Color color) {
        super(color);
    }
    /**
     * @return this piece's algebraic name
     */
    @Override public String algebraicName() {
        return "";
    }
    /**
     * @return this piece's FEN name
     */
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "P";
        }
        return "p";
    }
    /**
     * @param square the starting square of this piece
     * @return this an array of possible squares this piece could move to
     */
    @Override public Square[] movesFrom(Square square) {
        char rank = square.getRank();
        char file = square.getFile();
        if (getColor() == Color.WHITE) {
            if (rank == '8') {
                return new Square[0];
            } else if (rank == '2') {
                return new Square[]{new Square(file, '4'),
                    new Square(file, '3')};
            } else {
                return new Square[]{new Square(file, (char) (rank + 1))};
            }
        } else {
            if (rank == '1') {
                return new Square[0];
            } else if (rank == '7') {
                return new Square[]{new Square(file, '5'),
                    new Square(file, '6')};
            } else {
                return new Square[]{new Square(file, (char) (rank - 1))};
            }
        }
    }
}