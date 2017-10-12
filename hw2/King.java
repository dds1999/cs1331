public class King extends Piece {
    public King(Color color) {
        super(color);
    }
    @Override public String algebraicName() {
        return "K";
    }
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "K";
        }
        return "k";
    }
    @Override public Square[] movesFrom(Square square) {
        int[] currentPosition = square.getBoardIndex();
        int row = currentPosition[0];
        int col = currentPosition[1];
        int[][] possible = {
            {row - 1, col + 1},
            {row - 1, col},
            {row - 1, col - 1},
            {row + 1, col + 1},
            {row + 1, col},
            {row + 1, col - 1},
            {row, col + 1},
            {row, col - 1},
        };
        int nullCount = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i][0] < 0 || possible[i][0] > 7 || possible[i][1] < 0
                || possible[i][1] > 7) {
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