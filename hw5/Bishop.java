/**
 * Represents a bishop chess object
 * @author dds7
 * @version 2
 */
public class Bishop extends Piece {
    /**
     * Constructor for a bishop
     * @param color the color of a given bishop
     */
    public Bishop(Color color) {
        super(color);
    }
    /**
     * @return this piece's algebraic name
     */
    @Override public String algebraicName() {
        return "B";
    }
    /**
     * @return this piece's FEN name
     */
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "B";
        }
        return "b";
    }
    /**
     * @param square the starting square of this piece
     * @return this an array of possible squares this piece could move to
     */
    @Override public Square[] movesFrom(Square square) {
        Square[] sq = new Square[27];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();
        for (int i = 1; i < 9; i++) {
            char[] ranks = new char[]{(char) (rank + i), (char) (rank - i)};
            char[] files = new char[]{(char) (file + i), (char) (file - i)};
            if (isInBoard(files[0], ranks[0])) {
                sq[counter++] = new Square(files[0], ranks[0]);
            }
            if (isInBoard(files[1], ranks[0])) {
                sq[counter++] = new Square(files[1], ranks[0]);
            }
            if (isInBoard(files[0], ranks[1])) {
                sq[counter++] = new Square(files[0], ranks[1]);
            }
            if (isInBoard(files[1], ranks[1])) {
                sq[counter++] = new Square(files[1], ranks[1]);
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;

    }
}