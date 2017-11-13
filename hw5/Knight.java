/**
 * Represents a knight chess object
 * @author dds7
 * @version 1
 */
public class Knight extends Piece {
    /**
     * Constructor for a knight
     * @param color the color of a given knight
     */
    public Knight(Color color) {
        super(color);
    }
    /**
     * @return this piece's algebraic name
     */
    @Override public String algebraicName() {
        return "N";
    }
    /**
     * @return this piece's FEN name
     */
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "N";
        }
        return "n";
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
        char[] ranks = new char[]{(char) (rank - 2), (char) (rank - 1),
            (char) (rank + 1), (char) (rank + 2)};
        char[] files = new char[]{(char) (file - 2), (char) (file - 1),
            (char) (file + 1), (char) (file + 2)};

        if (isInBoard(files[0], ranks[1])) {
            sq[counter++] = new Square(files[0], ranks[1]);
        }
        if (isInBoard(files[0], ranks[2])) {
            sq[counter++] = new Square(files[0], ranks[2]);
        }
        if (isInBoard(files[1], ranks[0])) {
            sq[counter++] = new Square(files[1], ranks[0]);
        }
        if (isInBoard(files[1], ranks[3])) {
            sq[counter++] = new Square(files[1], ranks[3]);
        }
        if (isInBoard(files[2], ranks[0])) {
            sq[counter++] = new Square(files[2], ranks[0]);
        }
        if (isInBoard(files[2], ranks[3])) {
            sq[counter++] = new Square(files[2], ranks[3]);
        }
        if (isInBoard(files[3], ranks[1])) {
            sq[counter++] = new Square(files[3], ranks[1]);
        }
        if (isInBoard(files[3], ranks[2])) {
            sq[counter++] = new Square(files[3], ranks[2]);
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}