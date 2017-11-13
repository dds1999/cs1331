import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelloJavaFx extends Application {

    int count = 0;

    public void start(Stage stage) {
        // UI control

        Label counterLabel = new Label("Count : 0");
        Button incButton = new Button("Increment Count");
        incButton.setOnAction(event ->
        {
            counterLabel.setText("Count : " + (++count));
        });
        // new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent e) {
        //         counterLabel.serText("Count :" + (++count));
        //     }
        // }

        //Add UI to scene (Children to node?)
        VBox root = new VBox();
        root.getChildren().addAll(counterLabel, incButton);
        Scene scene = new Scene(root);

        //Set stage to scene
        stage.setScene(scene);
        stage.setTitle("I am confused");
        stage.show();


        // Label message = new Label("Hello, javafx...");
        // message.setFont(new Font(100));
        // stage.setScene(new Scene(message));
        // stage.setTitle("hello!");
        // stage.show();

        // Platform.exit();
        // Stage -> Scene -> HBox -> VBox
        // Structured Programming. User can't interrupt program, it has a sequence
        // Even driven program. Goes until a certain point. Then it waits for user input -- program is waiting for an event to occur
    }
}