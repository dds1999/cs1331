public class Rook extends Piece {
	public Rook(Color color){
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
	}
}