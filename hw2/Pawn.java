public class Pawn extends Piece {
	public Pawn(Color color){
		super(color);
	}
	@Override public String algebraicName() {
		return "";
	}
	@Override public String fenName() {	
		if (super.getColor()== Color.WHITE) {
			return "P";
		}
		return "p";
	}
	@Override public Square[] movesFrom(Square square) {
		return null;
	}
}