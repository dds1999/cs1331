public class Knight extends Piece {
	public Knight(Color color){
		super(color);
	}
	@Override public String algebraicName() {
		return "N";
	}
	@Override public String fenName() {	
		if (super.getColor() == Color.WHITE) {
			return "N";
		}
		return "n";
	}
	@Override public Square[] movesFrom(Square square) {
		return null;
	}
}