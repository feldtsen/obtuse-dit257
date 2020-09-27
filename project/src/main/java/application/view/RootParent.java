package application.view;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootParent extends VBox {
    private static RootParent instance = null;

    private RootParent(Stage primaryStage) {
        NavigationParent navigationParent = NavigationParent.getInstance();
        BoardParent boardParent = BoardParent.getInstance();


        this.getChildren().addAll(boardParent, navigationParent);

        this.setId("rootParent");
        this.getStylesheets().add(StylesheetRetriever.stylesheet);

        this.setRelativeSize(boardParent, primaryStage, .85);
        this.setRelativeSize(navigationParent, primaryStage, .15);

        navigationParent.getChildren().addAll(
                BoardNavigationButton.getInstance()
        );

    }

    public static RootParent getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new RootParent(primaryStage);
        }
        return instance;
    }

    private void setRelativeSize(Region region, Stage primaryStage, double heightPercentage) {
        region.prefWidthProperty().bind(primaryStage.widthProperty().multiply(heightPercentage));
        region.prefHeightProperty().bind(primaryStage.heightProperty().multiply(heightPercentage));
    }

}
