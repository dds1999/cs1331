public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }
    @Override public String algebraicName() {
        return "B";
    }
    @Override public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "B";
        }
        return "b";
    }
    @Override public Square[] movesFrom(Square square) {
        return null;
    }
    public static void main(String[] args) {
        Rook x = new Rook(Color.WHITE);
        x.movesFrom(new Square("d4"));
        System.out.println();
    }
}