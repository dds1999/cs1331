public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }
    @Override public String algebraicName() {
        return "Q";
    }
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "Q";
        }
        return "q";
    }
    @Override public Square[] movesFrom(Square square) {
        return null;
    }
}