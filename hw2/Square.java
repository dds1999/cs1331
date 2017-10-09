public class Square {
	private char rank;
	private char file;
	
	public Square(char file, char rank) {
		this("" + file + rank);	
	}
	
	public Suare(String name) {
		this.rank = name.charAt(0);
		this.file = name.charAt(1);
	}
	
	@override public String toString() {
		return ("" + rank + file);
	}
	
	@override public boolean equals(Object other) {
		if (null == other) { return false; }
		if (this == other) { return true; }
		if (!(other instanceof Square)) { return false; }
		Square that = (Square) other;
		return (this.rank == that.rank && this.file == that.file);
	}
}