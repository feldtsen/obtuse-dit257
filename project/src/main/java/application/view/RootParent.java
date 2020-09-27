package application.view;

import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootParent extends VBox {
    private static RootParent instance = null;

    private RootParent(Stage primaryStage) {
        NavigationParent navigationParent = NavigationParent.getInstance();
        PageParent boardParent = PageParent.getInstance();


        this.getChildren().addAll(boardParent, navigationParent);

        this.setId("rootParent");
        this.getStylesheets().add(ResourceLoader.stylesheet);

        this.setResponsiveSize(boardParent, primaryStage, .80);
        this.setResponsiveSize(navigationParent, primaryStage, .20);

    }

    public static RootParent getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new RootParent(primaryStage);
        }
        return instance;
    }

    private void setResponsiveSize(Region region, Stage primaryStage, double heightPercentage) {
        region.prefWidthProperty().bind(primaryStage.widthProperty());

        region.prefHeightProperty().bind(primaryStage.heightProperty().multiply(heightPercentage));
    }

}
