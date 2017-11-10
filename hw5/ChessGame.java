import java.util.List;
import java.util.Optional;
import java.util.Predicate;
/**
 *
 * @author dds7
 * @version 1
 */
public class ChessGame {
    private List<Move> moves;

    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    public Move getMoves() {
        return moves;
    }

    public Move getMove(int n) {
        return moves.get(n - 1);
    }

    public List<Move> filter(Predicate<Move> filter) {
        return null;
    }

    public List<Move> getMovesWithComment() {
        List<Move> withComments = new ArrayList<>();
        for (Move move : moves) {
            Optional<String> whiteComment =
                move.getWhitePly().getComment().filter((move) -> {
                    return
                });
        }
        // use a lambda
        return null;
    }

    public List<Move> getMovesWithoutComment() {
        // use anon inner class
        List<Move> withComments = new ArrayList<>();
        for (Move move : moves) {
            Predicate noComments = new Predicate<Move>() {
                public boolean test(Move move) {
                    return (move.getBlackPly().getComment().isPresent()
                        || move.getWhitePly().getComment().isPresent());
                }
            };
            // USE FILTER SOMEHOW
        }
        return withComments;
    }

    public List<Move> getMovesWithPiece(Piece p) {
        // use inner class
        List<Move> withComments = new ArrayList<>();
        for (Move move : moves) {
        }
        return null;
    }

    class PiecePredicate implements Predicate<Move> {
        public boolean test(Move move) {
            return false;
        }
    }


}