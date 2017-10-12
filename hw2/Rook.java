public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }
    @Override public String algebraicName() {
        return "R";
    }
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "R";
        }
        return "r";
    }
    @Override public Square[] movesFrom(Square square) {
        return null;
        for (int i = 0; i < board.length; i++) {
            boolean found = board[i][col].equals(currPlayer);
            if (found && !removed && row != i) {
                if (i < row) {
                    for (int temp = i + 1; temp < row; temp++) {
                        if (!board[temp][col].equals("")) {
                            open = false;
                        }
                    }
                } else {
                    for (int temp = i - 1; temp > row; temp--) {
                        if (!board[temp][col].equals("")) {
                            open = false;
                        }
                    }
                }
                if (open) {
                    board[i][col] = "";
                    removed = true;
                }
            }
        }
        open = (removed) ? false : true;
        for (int j = 0; j < board[row].length; j++) {
            boolean found = board[row][j].equals(currPlayer);
            if (col != j && found && !removed) {
                if (j < col) {
                    for (int temp = j + 1; temp < col; temp++) {
                        if (!board[row][temp].equals("")) {
                            open = false;
                        }
                    }
                } else {
                    for (int temp = j - 1; temp > col; temp--) {
                        if (!board[row][temp].equals("")) {
                            open = false;
                        }
                    }
                }
                if (open) {
                    board[row][j] = "";
                    removed = true;
                }
            }
            open = true;
        }
    }
}