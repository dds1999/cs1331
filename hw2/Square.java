public class Square {
	private char rank;
	private char file;
	private int[] boardIndex;
	
	public Square(char file, char rank) {
		this("" + file + rank);	
	}
	
	public Square(String name) {
		this.rank = name.charAt(0);
		this.file = name.charAt(1);
		this.boardIndex = this.setBoardIndex(name);
	}
	
	@Override public String toString() {
		return ("" + rank + file);
	}
	
	@Override public boolean equals(Object other) {
		if (null == other) { return false; }
		if (this == other) { return true; }
		if (!(other instanceof Square)) { return false; }
		Square that = (Square) other;
		return (this.rank == that.rank && this.file == that.file);
	}
		
	public int[] setBoardIndex(String givenName) {
		int[] position = new int[2];
		switch (givenName.charAt(0)) {
			case 'a':
				position[0] = 0;
				break;
			case 'b':
				position[0] = 1;
				break;
			case 'c':
				position[0] = 2;
				break;
			case 'd':
				position[0] = 3;
				break;
			case 'e':
				position[0] = 4;
				break;
			case 'f':
				position[0] = 5;
				break;
			case 'g':
				position[0] = 6;
				break;
			default:
				position[0] = 7;
				break;
			}
        position[1] = 8 - Integer.parseInt(givenName.substring(1));
        return position;
	}
	
	public int[] getBoardIndex() {
		return boardIndex;
	}
}