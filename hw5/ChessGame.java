import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

/**
 * This class outlines a chess game with a List of stored Moves
 * @author dds7
 * @version 1
 */
public class ChessGame {
    private List<Move> moves;

    /**
     * Constructs a ChessGame object
     * @param  moves the List of Moves played in this game
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * Gets the List of Moves played this game
     * @return List of Moves played in this game
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Gets the nth Move played in this game
     * @param n the number move requested
     * @return nth Move played in this game
     */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
     * Creates a new List of Moves filtered by some given Predicate
     * @param  filter a Predicate of type Move
     * @return a List of type Move only including elements that meet filter test
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> filteredList = new ArrayList<Move>();
        for (Move m : moves) {
            if (filter.test(m)) {
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    /**
     * Creates a new List containing only Moves from this game with comments
     * @return a List of type Move with all Moves from this game with comments
     */
    public List<Move> getMovesWithComment() {
        // use a lambda
        List<Move> withComments = this.filter((Move m) -> {
                return m.getBlackPly().getComment().isPresent()
                    || m.getWhitePly().getComment().isPresent();
            });
        return withComments;
    }

    /**
     * Creates a new List containing only Moves from this game without comments
     * @return List of type Move with all Moves from this game without comments
     */
    public List<Move> getMovesWithoutComment() {
        // use anon inner class
        List<Move> withoutComments = this.filter(new Predicate<Move>() {
            public boolean test(Move m) {
                return !(m.getBlackPly().getComment().isPresent()
                    || m.getWhitePly().getComment().isPresent());
            }
        });
        return withoutComments;
    }

    /**
     * Creates a new List containing only Moves including a certain chess piece
     * @param p the chess Piece all returned Moves should include
     * @return a List of type Move with all Moves containing Piece p
     */
    public List<Move> getMovesWithPiece(Piece p) {
        // use inner class
        class PiecePredicate implements Predicate<Move> {
            public boolean test(Move move) {
                return move.getBlackPly().getPiece().algebraicName().equals(
                    p.algebraicName())
                    || move.getWhitePly().getPiece().algebraicName().equals(
                    p.algebraicName());
            }
        }
        List<Move> movesOfThisPiece = this.filter(new PiecePredicate());
        return movesOfThisPiece;
    }
}