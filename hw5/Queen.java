/**
 * Represents a queen chess object
 * @author dds7
 * @version 2
 */
public class Queen extends Piece {
    /**
     * Constructor for a queen
     * @param color the color of a given queen
     */
    public Queen(Color color) {
        super(color);
    }
    /**
     * @return this piece's algebraic name
     */
    @Override public String algebraicName() {
        return "Q";
    }
    /**
     * @return this piece's FEN name
     */
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "Q";
        }
        return "q";
    }
    /**
     * @param square the starting square of this piece
     * @return this an array of possible squares this piece could move to
     */
    @Override public Square[] movesFrom(Square square) {
        int[] currentPosition = square.getBoardIndex();
        int row = currentPosition[0];
        int col = currentPosition[1];
        int[][] possible = {
            // I know this is super hacky but we can't use arraylist. I'm sorry
            // like rook
            {0, col},
            {1, col},
            {2, col},
            {3, col},
            {4, col},
            {5, col},
            {6, col},
            {7, col},
            {row, 0},
            {row, 1},
            {row, 2},
            {row, 3},
            {row, 4},
            {row, 5},
            {row, 6},
            {row, 7},
            // like bishop
            {row - 1, col - 1},
            {row - 2, col - 2},
            {row - 3, col - 3},
            {row - 4, col - 4},
            {row - 5, col - 5},
            {row - 6, col - 6},
            {row - 7, col - 7},
            {row + 1, col - 1},
            {row + 2, col - 2},
            {row + 3, col - 3},
            {row + 4, col - 4},
            {row + 5, col - 5},
            {row + 6, col - 6},
            {row + 7, col - 7},
            {row + 1, col + 1},
            {row + 2, col + 2},
            {row + 3, col + 3},
            {row + 4, col + 4},
            {row + 5, col + 5},
            {row + 6, col + 6},
            {row + 7, col + 7},
            {row - 1, col + 1},
            {row - 2, col + 2},
            {row - 3, col + 3},
            {row - 4, col + 4},
            {row - 5, col + 5},
            {row - 6, col + 6},
            {row - 7, col + 7}
        };
        int nullCount = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i][0] < 0 || possible[i][0] > 7 || possible[i][1] < 0
                || possible[i][1] > 7
                || (possible[i][0] == row && possible[i][1] == col)) {
                possible[i] = null;
                nullCount++;
            }
        }
        int[][] possibleAndValid = new int[possible.length - nullCount][2];
        int j = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i] != null) {
                possibleAndValid[j] = possible[i];
                j++;
            }
        }
        Square[] result = new Square[possibleAndValid.length];
        for (int i = 0; i < possibleAndValid.length; i++) {
            char file = (char) (possibleAndValid[i][1] + 97);
            int tempRank = 8 - possibleAndValid[i][0];
            tempRank = tempRank + 48;
            char rank = (char) tempRank;
            result[i] = new Square(file, rank);
        }
        return result;
    }
}