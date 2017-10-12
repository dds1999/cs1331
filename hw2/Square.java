public class Square {
    private char file;
    private char rank;
    private int[] boardIndex;

    public Square(char file, char rank) {
        this("" + file + rank);
    }

    public Square(String name) {
        this.file = name.charAt(0);
        this.rank = name.charAt(1);
        boardIndex = getBoardIndex();
    }

    @Override public String toString() {
        return ("" + file + rank);
    }

    @Override public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Square)) {
            return false;
        }
        Square that = (Square) other;
        return (this.rank == that.rank && this.file == that.file);
    }

    public int[] getBoardIndex() {
        int col = (int) file;
        int row = (int) rank;
        row -= 48;
        row = 8 - row;
        col -= 97;
        int[] result = {row, col};
        return result;
    }
}