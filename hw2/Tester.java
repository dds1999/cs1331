public class Tester {
    public static void main(String[] args) {
        Bishop b = new Bishop(Color.BLACK);
        Square[] result = b.movesFrom(new Square("a1"));
        King k = new King(Color.BLACK);
        result = k.movesFrom(new Square("a1"));
        Knight n = new Knight(Color.BLACK);
        result = n.movesFrom(new Square("a1"));
        Pawn p = new Pawn(Color.BLACK);
        result = p.movesFrom(new Square("a1"));
        Piece q = new Queen(Color.BLACK);
        result = q.movesFrom(new Square("a1"));
        Rook r = new Rook(Color.BLACK);
        result = r.movesFrom(new Square("a1"));
        Square s = new Square('a', '1');
        System.out.println(s);
        Piece knight = new Knight(Color.BLACK);
        System.out.println(knight.algebraicName().equals("N"));
        assert knight.fenName().equals("n");
        Square[] attackedSquares = knight.movesFrom(new Square("f6"));
        // test that attackedSquares contains e8, g8, etc.
        Square a1 = new Square("a1");
        Square otherA1 = new Square('a', '1');
        Square h8 = new Square("h8");
        assert a1.equals(otherA1);
        assert !a1.equals(h8);
    }

}