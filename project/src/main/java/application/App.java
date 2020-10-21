
package application;

import application.controller.ClientController;
import application.view.util.ResizeHelper;
import application.view.RootParent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    private final static double INITIAL_WIDTH  = 1200;
    private final static double INITIAL_HEIGHT = 655;
    private final static double MIN_WIDTH      = 1000;
    private final static double MIN_HEIGHT     = 655;
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        App.stage = stage;

        // We remove the default toolbar
        stage.initStyle(StageStyle.UNDECORATED);

        // Sets the taskbar icon to be our logo
        stage.getIcons().add(new Image(ResourceLoader.logoSymbol));

        // Set the application min width and height
        stage.setMinHeight(MIN_HEIGHT);
        stage.setMinWidth(MIN_WIDTH);

        // Set the root graphical component to out application and set initial size
        Scene scene = new Scene(RootParent.getInstance(), INITIAL_WIDTH, INITIAL_HEIGHT);
        stage.setScene(scene);
        stage.show();

        // Initialize the client part of the application
        ClientController.init();


        // Since we remove the default toolbar for the application window, we need to add some basic functionality to
        // resize the window and move it around
        ResizeHelper.draggable(stage);
        ResizeHelper.addResizeListener(stage);


    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getStage () {
        return stage;
    }


}
