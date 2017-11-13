/**
 * Represents a chess square  object
 * @author dds7
 * @version 2
 */
public class Square {
    private char file;
    private char rank;
    private String name;
    private int[] boardIndex;
    /**
     * Constructor for a chess square
     * @param file the file of a given square a-h
     * @param rank the rank of a given sqaure 1-8
     */
    public Square(char file, char rank) throws InvalidSquareException {
        this("" + file + rank);
    }
    /**
     * Constructor for a chess square
     * @param name the name of a given sqaure including both rank and file
     */
    public Square(String name) throws InvalidSquareException {
        this.name = name;
        if (name != null && name.length() == 2) {
            this.file = name.charAt(0);
            this.rank = name.charAt(1);
            if (file < 97 || file > 104 || rank < 49 || rank > 56) {
                throw new InvalidSquareException(name);
            }
        } else {
            throw new InvalidSquareException(name);
        }
        boardIndex = getBoardIndex();
    }
    /**
    *@return the file of this square
    */
    public char getFile() {
        return file;
    }
    /**
    *@return the rank of this square
    */
    public char getRank() {
        return rank;
    }
    /**
     * overriden toString method for squares
     */
    @Override public String toString() {
        return ("" + file + rank);
    }
    /**
     * Overriden equals method for sqaures
     * @param other the object to be compared to this sqaure
     * @return boolean value of whether this object equals the passed object
     */
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
    /**
     * Overriden hashCode method for Sqaures
     * @retun hashcode of this Square
     */
    @Override public int hashCode() {
        int sum = 0;
        sum += 17 * this.rank;
        sum *= 31;
        sum += 17 * this.file;
        return sum;
    }
    /**
     * finds an integer array containting the row and coloumn values of where
     * this square would be on an array with the dimensions of a chess board
     * @return integer array containting the row and coloumn values of the
     * location of this square on an array represenation of the chess board
     */
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