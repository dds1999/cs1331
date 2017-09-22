import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PgnReader {
    private static String[][] board = createBoard();
    private static int turn = 1;
    /**
     * Find the tagName tag pair in a PGN game and return its value.
     *
     * @see http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm
     *
     * @param tagName the name of the tag whose value you want
     * @param game a `String` containing the PGN text of a chess game
     * @return the value in the named tag pair
     */
    public static String tagValue(String tagName, String game) {
        String[] fileSplitByQuotes = game.split("\"");
        String value = "";
        for (int i = 0; i < fileSplitByQuotes.length - 1; i++) {
            if (fileSplitByQuotes[i].contains(tagName)) {
                value = fileSplitByQuotes[++i];
                return value;
            }
        }
        return "NOT GIVEN";
    }

    /**
     * Play out the moves in game and return a String with the game's
     * final position in Forsyth-Edwards Notation (FEN).
     *
     * @see http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm#c16.1
     *
     * @param game a `Strring` containing a PGN-formatted chess game or opening
     * @return the game's final position in FEN.
     */
    public static String finalPosition(String gameIn) {

        boolean gameOver = false;
        while (!getNextMove(gameIn, turn).equals("STOP")) {
            String move = getNextMove(gameIn, turn);
            readMove(move);
            turn++;
        }
        String finalString = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!(board[i][j].equals(""))) {
                    finalString += (board[i][j]);
                } else {
                    int count = 0;
                    while (j < board[i].length && board[i][j].equals("")) {
                        count++;
                        j++;
                    }
                    finalString += count;
                    j--;
                }
            }
            finalString += "/";
        }

        return finalString;
    }

    public static String[][] createBoard() {
        String[][] newBoard = new String[8][8];
        newBoard[0] = new String[]{"r", "n", "b", "q", "k", "b", "n", "r"};
        newBoard[1] = new String[]{"p", "p", "p", "p", "p", "p", "p", "p"};
        newBoard[2] = new String[]{"", "", "", "", "", "", "", ""};
        newBoard[3] = new String[]{"", "", "", "", "", "", "", ""};
        newBoard[4] = new String[]{"", "", "", "", "", "", "", ""};
        newBoard[5] = new String[]{"", "", "", "", "", "", "", ""};
        newBoard[6] = new String[]{"P", "P", "P", "P", "P", "P", "P", "P"};
        newBoard[7] = new String[]{"R", "N", "B", "Q", "K", "B", "N", "R"};
        return newBoard;
    }

    public static String getNextMove(String game, int whatTurn) {
        int start = 0;
        int end = 0;
        String currTurn = whatTurn + ".";
        String nextTurn = (whatTurn + 1) + ".";
        start = game.indexOf(currTurn) + currTurn.length();
        if (game.contains(nextTurn)) {
            end = game.indexOf(nextTurn);
            return game.substring(start, end);
        } else if (game.contains(currTurn)) {
            return game.substring(start);
        } else {
            return "STOP";
        }
    }
    public static void readMove(String move) {
        move = move.trim();
        int[] info;
        String[] playerMoves = move.split("\\s");
        for (int i = 0; i < playerMoves.length; i++) {
            String curr = playerMoves[i];
            if (curr.contains("K") || curr.contains("k")) {
                info = basicInfoForNonPawns(curr, i);
                kingMove(info);
            } else if (curr.contains("Q") || curr.contains("q")) {
                info = basicInfoForNonPawns(curr, i);
                queenMove(info);
            } else if (curr.contains("B") || curr.contains("b")) {
                info = basicInfoForNonPawns(curr, i);
                bishopMove(info);
            } else if (curr.contains("N") || curr.contains("n")) {
                info = basicInfoForNonPawns(curr, i);
                knightMove(info);
            } else if (curr.contains("R") || curr.contains("r")) {
                info = basicInfoForNonPawns(curr, i);
                rookMove(info);
            } else if (curr.contains("x")) {
                pawnCapture(curr, i);
            } else {
                pawnMove(curr, i);
            }
        }
    }
    public static int[] basicInfoForNonPawns(String currIn, int whoseTurn) {
        String curr = currIn.trim();
        int[] result = new int[3];
        int col;
        int row = Integer.parseInt(curr.substring(2, 3)) - 1;
        if (curr.contains("a")) {
            col = 0;
        } else if (curr.contains("b")) {
            col = 1;
        } else if (curr.contains("c")) {
            col = 2;
        } else if (curr.contains("d")) {
            col = 3;
        } else if (curr.contains("e")) {
            col = 4;
        } else if (curr.contains("f")) {
            col = 5;
        } else if (curr.contains("g")) {
            col = 6;
        } else {
            col = 7;
        }
        result[0] = row;
        result[1] = col;
        result[2] = whoseTurn;
        return result;
    }
    public static void pawnMove(String currIn, int whoseTurn) {
        String curr = currIn.trim();
        int col;
        int row = Integer.parseInt(curr.substring(1, 2)) - 1;
        if (curr.contains("a")) {
            col = 0;
        } else if (curr.contains("b")) {
            col = 1;
        } else if (curr.contains("c")) {
            col = 2;
        } else if (curr.contains("d")) {
            col = 3;
        } else if (curr.contains("e")) {
            col = 4;
        } else if (curr.contains("f")) {
            col = 5;
        } else if (curr.contains("g")) {
            col = 6;
        } else {
            col = 7;
        }
        if (whoseTurn == 0) {
            if (row != 7 || row != 0) {
                board[row][col] = "p";
            } else {
                board[row][col] = "k";
            }
            if (board[row - 1][col].equals("p")) {
                board[row - 1][col] = "";
            } else if (board[row - 2][col].equals("p") && turn == 1) {
                board[row - 2][col] = "";
            }
        } else {
            if (row != 7 || row != 0) {
                board[row][col] = "P";
            } else {
                board[row][col] = "K";
            }
            if (board[row + 1][col].equals("P")) {
                board[row + 1][col] = "";
            } else if (board[row + 2][col].equals("P") && turn == 1) {
                board[row + 2][col] = "";
            }
        }
        System.out.println(currIn + " = " + row + " , " + col + " , " + turn);

    }
    public static void pawnCapture(String currIn, int whoseTurn) {
        /*if (curr.contains("p")) {
            if (row != 7) {
                board[row][col] = "p";
            } else {
                board[row][col] = "k";
            }
            if (board[row - 1][col].equals("p")) {
                board[row - 1][col] = "";
            } else if (board[row - 2][col].equals("p")) {
                board[row - 2][col] = "";
            }
        } else if (curr.contains("P")) {
            if (row != 0) {
                board[row][col] = "p";
            } else {
                board[row][col] = "k";
            }
            if (board[row + 1][col].equals("P")) {
                board[row + 1][col] = "";
            } else if (board[row + 2][col].equals("P")) {
                board[row - 2][col] = "";
            }
        }*/

    }
    public static void rookMove(int[] infoIn) {
    }
    public static void knightMove(int[] infoIn) {
    }
    public static void bishopMove(int[] infoIn) {
    }
    public static void queenMove(int[] infoIn) {
    }
    public static void kingMove(int[] infoIn) {
    }
    /**
     * Reads the file named by path and returns its content as a String.
     *
     * @param path the relative or abolute path of the file to read
     * @return a String containing the content of the file
     */
    public static String fileContent(String path) {
        Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String game = fileContent(args[0]);
        System.out.format("Event: %s%n", tagValue("Event", game));
        System.out.format("Site: %s%n", tagValue("Site", game));
        System.out.format("Date: %s%n", tagValue("Date", game));
        System.out.format("Round: %s%n", tagValue("Round", game));
        System.out.format("White: %s%n", tagValue("White", game));
        System.out.format("Black: %s%n", tagValue("Black", game));
        System.out.format("Result: %s%n", tagValue("Result", game));
        System.out.printf("Final Position: %s%n", finalPosition(game));
        for (String[] arr : board) {
            for (String letter : arr) {
                if (letter.equals("")) {
                    System.out.print(" ");
                } else {
                    System.out.print(letter);
                }
            }
            System.out.println();
        }
    }
}