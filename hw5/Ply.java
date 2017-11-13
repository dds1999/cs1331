import java.util.Optional;

/**
 * This class outlines a single chess play by either player
 * @author dds7
 * @version 1
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
     * Constructs a Ply oject
     * @param piece the chess peice moved in this play
     * @param from the starting Square of the piece moved
     * @param to the ending Square of the piece moved
     * @param comment an optional comment describing the play
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    /**
    * Gets the piece used in the play
    * @return piece used in this play
    */
    public Piece getPiece() {
        return piece;
    }

    /**
    * Gets the starting Square of the piece moved
    * @return the starting Square of the piece moved
    */
    public Square getFrom() {
        return from;
    }

    /**
    * Gets the ending Square of the piece moved
    * @return the ending Square of the piece moved
    */
    public Square getTo() {
        return to;
    }

    /**
    * Gets the optional comment stored about this play
    * @return the optional comment stored about this play
    */
    public Optional<String> getComment() {
        return comment;
    }

}