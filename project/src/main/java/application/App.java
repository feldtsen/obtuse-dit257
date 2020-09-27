
package application;

import application.view.RootParent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(RootParent.getInstance(stage), 1000, 600);

        stage.setMinHeight(600);
        stage.setMinWidth(800);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
