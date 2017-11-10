/**
 * This class outlines a move of chess game comprise of each player's play/turn
 * @author dds7
 * @version 1
 */
public class Move {
    private Ply blackPly;
    private Ply whitePly;

    /**
     * Constructs a Move object with a play for the white and black players
     * @param whitePLy the play of the white-piece player
     * @param blackPLy the play of the black-piece player
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
    * Gets the play of the black-piece player for this turn
    * @return the play of the black-piece player for this turn
    */
    public Ply getBlackPly() {
        return blackPly;
    }

    /**
    * Gets the play of the white-piece player for this turn
    * @return the play of the white-piece player for this turn
    */
    public Ply getWhitePly() {
        return whitePly;
    }

}