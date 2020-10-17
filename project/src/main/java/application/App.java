
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
    private final static double MIN_WIDTH      = 900;
    private final static double MIN_HEIGHT     = 655;
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        App.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);

        stage.getIcons().add(new Image(ResourceLoader.logoSymbol));

        Scene scene = new Scene(RootParent.getInstance(), INITIAL_WIDTH, INITIAL_HEIGHT);

        stage.setMinHeight(MIN_HEIGHT);
        stage.setMinWidth(MIN_WIDTH);

        ClientController.init();

        stage.setScene(scene);
        stage.show();

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
