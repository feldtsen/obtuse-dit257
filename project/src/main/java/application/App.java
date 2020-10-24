
package application;

import application.controller.ClientController;
import application.view.util.ResizeHelper;
import application.view.RootParent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// The root class of the application. This class is responsible for launching
// the app.
public class App extends Application {
    // The initial width of the application window
    private final static double INITIAL_WIDTH  = 1200;

    // The initial height of the application window
    private final static double INITIAL_HEIGHT = 655;

    // The minimum width of the application window
    private final static double MIN_WIDTH      = 1000;

    // The minimum height of the application window
    private final static double MIN_HEIGHT     = 655;

    // The root stage (or window) of the application
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
