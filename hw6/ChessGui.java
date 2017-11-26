import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
/**
 * Constructs a chess database GUI
 * @author dds7
 * @version 1
 */
public class ChessGui extends Application {
    /**
    * Constructs the main stage of this GUI
    * @param stage the Stage to be displayed
    */
    public void start(Stage stage) throws Exception {

        TableView<ChessGame> table = new TableView<>();
        table.setEditable(true);

        TableColumn<ChessGame, String> eventCol = new TableColumn<>("Event");
        eventCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("event"));
        TableColumn<ChessGame, String> siteCol = new TableColumn<>("Site");
        siteCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("site"));
        TableColumn<ChessGame, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("date"));
        TableColumn<ChessGame, String> whiteCol = new TableColumn<>("White");
        whiteCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("white"));
        TableColumn<ChessGame, String> blackCol = new TableColumn<>("Black");
        blackCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("black"));
        TableColumn<ChessGame, String> resultCol = new TableColumn<>("Result");
        resultCol.setCellValueFactory(
                new PropertyValueFactory<ChessGame, String>("result"));
        table.getColumns().addAll(eventCol, siteCol, dateCol, whiteCol,
            blackCol, resultCol);

        ObservableList<ChessGame> data = FXCollections.observableArrayList(
            new ChessDb().getGames());
        data.addAll(getChessGamesInDirectory()); // Extra cedit line
        table.setItems(data);

        SelectionModel<ChessGame> mod = table.getSelectionModel();

        Button viewButton = new Button("View");
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!mod.isEmpty()) {
                    ChessGame selectedGame = mod.getSelectedItem();
                    Scene gameScene = getSelectedScene(selectedGame);
                    Stage gameStage = new Stage();
                    gameStage.setScene(gameScene);
                    gameStage.show();
                }
            }
        });

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(viewButton);
        buttonBox.getChildren().addAll(dismissButton);

        VBox endBox = new VBox();
        endBox.getChildren().addAll(table);
        endBox.getChildren().addAll(buttonBox);

        Scene scene = new Scene(endBox);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setTitle("Chess Database GUI");
        stage.show();
    }
    public Scene getSelectedScene(ChessGame selectedGame) {
        ListView<String> list = new ListView<String>();
        // no get moves method.. this is my hacky fix
        ArrayList<String> moves = new ArrayList<>();
        int i = 1;
        int size = 0;
        try {
            while (i < Integer.MAX_VALUE) {
                moves.add(selectedGame.getMove(i));
                i++;
            }
        } catch (Exception x) {
            size = i;
        }
        ObservableList<String> items = FXCollections.
            observableArrayList(moves);
        list.setItems(items);

        Label eventLabel = new Label("Event\t: "
            + selectedGame.getEvent());
        eventLabel.setFont(new Font("Courier New", 15));

        Label siteLabel = new Label("Site\t: "
            + selectedGame.getSite());
        siteLabel.setFont(new Font("Courier New", 15));

        Label dateLabel = new Label("Date\t: "
            + selectedGame.getDate());
        dateLabel.setFont(new Font("Courier New", 15));

        Label whiteLabel = new Label("White\t: "
            + selectedGame.getWhite());
        whiteLabel.setFont(new Font("Courier New", 15));

        Label blackLabel = new Label("Black\t: "
            + selectedGame.getBlack());
        blackLabel.setFont(new Font("Courier New", 15));

        Label resultLabel = new Label("Result\t: "
            + selectedGame.getResult());
        resultLabel.setFont(new Font("Courier New", 15));

        VBox gameBox = new VBox();
        gameBox.getChildren().addAll(eventLabel, siteLabel,
            dateLabel, whiteLabel, blackLabel, resultLabel, list);

        Scene gameScene = new Scene(gameBox);
        return gameScene;
    }
    // Extra Credit Section
    public static List<ChessGame> getChessGamesInDirectory() {
        List<ChessGame> results = new ArrayList<ChessGame>();
        File[] files = new File(System.getProperty("user.dir")).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().contains(".pgn")) {
                results.add(convertFileToGame(file.toPath()));
            }
        }
        return results;
    }
    public static ChessGame convertFileToGame(Path file) {
        String rawStringGame = fileContent(file);
        String event = tagValue("Event", rawStringGame);
        String site =  tagValue("Site", rawStringGame);
        String date =  tagValue("Date", rawStringGame);
        String white =  tagValue("White", rawStringGame);
        String black =  tagValue("Black", rawStringGame);
        String result =  tagValue("Result", rawStringGame);
        ChessGame temp = new ChessGame(event, site, date, white, black,
            result);
        ArrayList<String> allMoves = getMovesFromStringGame(rawStringGame);
        for (String move : allMoves) {
            temp.addMove(move);
        }
        return temp;
    }
    /**
     * Reads the file named by path and returns its content as a String.
     *
     * @param path the relative or abolute path of the file to read
     * @return a String containing the content of the file
     */
    public static String fileContent(Path file) {
        //Path file = Paths.get(path);
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
    public static ArrayList<String> getMovesFromStringGame(String game) {
        int turn = 1;
        String turnAsString = turn + ".";
        ArrayList<String> result = new ArrayList<>();
        while (game.contains(turnAsString)) {
            int start = game.indexOf(turnAsString);
            start += turnAsString.length();
            turnAsString = ++turn + ".";
            int end = game.indexOf(turnAsString);
            if (end != -1) {
                result.add(game.substring(start, end).trim());
            } else {
                result.add(game.substring(start).trim());
            }
        }
        return result;
    }
    // public static ArrayList<String> getMovesFromChessGame(ChessGame game) {
    // }
}