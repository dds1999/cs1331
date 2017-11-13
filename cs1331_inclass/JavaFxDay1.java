import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.Stage;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HelloJavaFx extends Application {
    public void start(Stage stage) {
        Label message = new Label("Hello, javafx...");
        message.setFont(new Font(100));
        stage.setScene(new Scene(message));
        stage.setTitle("hello!");
        stage.show();
    }
}