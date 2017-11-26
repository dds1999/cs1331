import java.util.ArrayList;
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
        table.setItems(data);

        SelectionModel<ChessGame> mod = table.getSelectionModel();

        Button viewButton = new Button("View");
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!mod.isEmpty()) {
                    ChessGame selectedGame = mod.getSelectedItem();
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
}