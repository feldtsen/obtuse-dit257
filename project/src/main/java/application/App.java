
package application;

import application.controller.ClientController;
import application.model.client.Client;
import application.model.util.TagParser;
import application.view.RootParent;
import application.view.pages.board.posts.TagDropdown;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private final static double INITIAL_WIDTH  = 1000;
    private final static double INITIAL_HEIGHT = 600;
    private final static double MIN_WIDTH      = 800;
    private final static double MIN_HEIGHT     = 600;

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(RootParent.getInstance(stage), INITIAL_WIDTH, INITIAL_HEIGHT);

        stage.setMinHeight(MIN_HEIGHT);
        stage.setMinWidth(MIN_WIDTH);

        ClientController.init();

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
