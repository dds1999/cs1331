// GUI Graphical User Interface
// Javafx is a "play"
// Stages display scenes
// Scenes have images, buttons, toolbars, etc (Props)

// Everything is structured like a tree.
// The stage is the parent node

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.event.*; // ActionEvent and EventHandler

public class MyApplication extends Application {
    public void start(Stage stage) {
        Circle c = new Circle(10, 10, 90);
        Circle c1 = new Circle(10, 10, 90);
        Circle c2 = new Circle(10, 10, 90);

        Image image = new Image("bookworm.jpg");

        ImageView iview = new ImageView(image);


        Button button = new Button("Click here");
        BorderPane borderPane = new BorderPane();
        //vbox.getChildren().addAll(button);
        borderPane.setCenter(button);

        button.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent e) {
                // how GUI responds to user clicking on a a button
                borderPane.setTop(iview);
            }
        });


        Scene scene = new Scene(borderPane);

        stage.setScene(scene);

        stage.show();
    }
}